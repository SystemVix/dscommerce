package com.vixsys.dscommerce.controllers;

import com.vixsys.dscommerce.dtos.ProductDto;
import com.vixsys.dscommerce.entities.Product;
import com.vixsys.dscommerce.repositories.ProductRepository;
import com.vixsys.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController
{
   @Autowired
   private ProductService service;

   @GetMapping(value = "/{id}")
   public ProductDto findById(@PathVariable Long id)
   {
      return service.findById(id);
   }

   @GetMapping
   public Page<ProductDto> findAll(Pageable pageable)
   {
      return service.findAll(pageable);
   }

   @PostMapping
   public ProductDto insert(@RequestBody ProductDto dto)
   {
      return service.insert(dto);
   }
}
