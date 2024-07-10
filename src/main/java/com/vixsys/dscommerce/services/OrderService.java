package com.vixsys.dscommerce.services;

import com.vixsys.dscommerce.dtos.OrderDto;
import com.vixsys.dscommerce.dtos.OrderItemDto;
import com.vixsys.dscommerce.entities.*;
import com.vixsys.dscommerce.repositories.OrderItemRepository;
import com.vixsys.dscommerce.repositories.OrderRepository;
import com.vixsys.dscommerce.repositories.ProductRepository;
import com.vixsys.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService
{
   @Autowired
   private AuthService authService;

   @Autowired
   private OrderItemRepository orderItemRepository;

   @Autowired
   private OrderRepository repository;

   @Autowired
   private ProductRepository productRepository;

   @Autowired
   private UserService userService;

   // Método para buscar um pedido por ID
   @Transactional(readOnly = true)
   public OrderDto findById(Long id)
   {
      Order order = repository.findById(id).orElseThrow
              (() -> new ResourceNotFoundException("Pedido não encontrado!"));
      authService.validateSelfOrAdmin(order.getClient().getId_user());
      return new OrderDto(order);
   }

   @Transactional
   public OrderDto insert(OrderDto dto)
   {
      Order order = new Order();
      order.setMoment(Instant.now());
      order.setStatus(OrderStatus.AGUARDANDO);
      User user = userService.authenticated();
      order.setClient(user);
      for (OrderItemDto itemDto : dto.getItems())
      {
         Product product = productRepository.getReferenceById(itemDto.getProductId());
         OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPriceTable());
         order.getItems().add(item);
      }
      repository.save(order);
      orderItemRepository.saveAll(order.getItems());
      return new OrderDto(order);
   }
}
