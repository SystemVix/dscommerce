package com.vixsys.dscommerce.controllers;

import com.vixsys.dscommerce.dtos.ProductDto;
import com.vixsys.dscommerce.dtos.ProductMinDto;
import com.vixsys.dscommerce.services.ProductService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
   public ResponseEntity<Page<ProductMinDto>> findAll
      (
         @RequestParam(name = "name", defaultValue = "") String name,
         Pageable pageable
      )
   {
      Page<ProductMinDto> dto = service.findAll(name, pageable);
      return ResponseEntity.ok(dto);
   }

   @PreAuthorize("hasRole('ROLE_ADMIN')")
   @PostMapping
   public ResponseEntity<ProductDto> insert(@Valid @RequestBody ProductDto dto)
   {
      dto = service.insert(dto);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
         .path("/{id}").buildAndExpand(dto.getId_product()).toUri();
      return  ResponseEntity.created(uri).body(dto);
   }

   @PreAuthorize("hasRole('ROLE_ADMIN')")
   @PutMapping(value = "/{id}")
   public ResponseEntity<ProductDto> update(@PathVariable Long id, @Valid @RequestBody ProductDto dto)
   {
      dto = service.update(id, dto);
      return ResponseEntity.ok(dto);
   }

   @PreAuthorize("hasRole('ROLE_ADMIN')")
   @DeleteMapping(value = "/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id)
   {
      service.delete(id);
      return ResponseEntity.noContent().build();
   }
}
