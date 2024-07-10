package com.vixsys.dscommerce.controllers;

import com.vixsys.dscommerce.dtos.OrderDto;
import com.vixsys.dscommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/orders")
public class OrderController
{
   @Autowired
   private OrderService service;

   @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
   @GetMapping(value = "/{id}")
   public ResponseEntity<OrderDto> findById(@PathVariable Long id)
   {
      OrderDto dto = service.findById(id);
      return ResponseEntity.ok(dto);
   }

   @PreAuthorize("hasRole('ROLE_CLIENT')")
   @PostMapping
   public ResponseEntity<OrderDto> insert(@Valid @RequestBody OrderDto dto)
   {
      dto = service.insert(dto);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
              .path("/{id}").buildAndExpand(dto.getId()).toUri();
      return  ResponseEntity.created(uri).body(dto);
   }
}
