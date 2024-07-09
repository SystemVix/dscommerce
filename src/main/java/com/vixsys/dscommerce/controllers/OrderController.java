package com.vixsys.dscommerce.controllers;

import com.vixsys.dscommerce.dtos.OrderDto;
import com.vixsys.dscommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
public class OrderController
{
   @Autowired
   private OrderService service;

   @PreAuthorize("hasRole('ROLE_ADMIN')")
   @GetMapping(value = "/{id}")
   public ResponseEntity<OrderDto> findById(@PathVariable Long id)
   {
      OrderDto dto = service.findById(id);
      return ResponseEntity.ok(dto);
   }
}
