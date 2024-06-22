package com.vixsys.dscommerce.controllers;

import com.vixsys.dscommerce.dtos.ProductDto;
import com.vixsys.dscommerce.entities.Product;
import com.vixsys.dscommerce.repositories.ProductRepository;
import com.vixsys.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController
{
   @Autowired
   private ProductService service;

   @GetMapping(value = "/{id}")
   public ResponseEntity<ProductDto> findById(@PathVariable Long id)
   {
      ProductDto dto = service.findById(id);
      return ResponseEntity.ok(dto);
   }

   @GetMapping
   public ResponseEntity<Page<ProductDto>> findAll(Pageable pageable)
   {
      Page<ProductDto> dto = service.findAll(pageable);
      return ResponseEntity.ok(dto);
   }

   @PostMapping
   public ResponseEntity<ProductDto> insert(@RequestBody ProductDto dto)
   {
      dto = service.insert(dto);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
         .path("/{id}").buildAndExpand(dto.getId_product()).toUri();
      return  ResponseEntity.created(uri).body(dto);
   }
}
