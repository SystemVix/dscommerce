package com.vixsys.dscommerce.services;

import com.vixsys.dscommerce.dtos.OrderDto;
import com.vixsys.dscommerce.entities.Order;
import com.vixsys.dscommerce.repositories.OrderRepository;
import com.vixsys.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService
{
   @Autowired
   private OrderRepository repository;

   // Método para buscar um pedido por ID
   @Transactional(readOnly = true)
   public OrderDto findById(Long id)
   {
      Order order = repository.findById(id).orElseThrow
              (() -> new ResourceNotFoundException("Pedido não encontrado!"));
      return new OrderDto(order);
   }
}
