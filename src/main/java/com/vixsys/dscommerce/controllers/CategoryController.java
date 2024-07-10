package com.vixsys.dscommerce.controllers;

import com.vixsys.dscommerce.dtos.CategoryDto;
import com.vixsys.dscommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController
{
   @Autowired
   private CategoryService service;

   @GetMapping
   public ResponseEntity<List<CategoryDto>> findAll()
   {
      List<CategoryDto> list = service.findAll();
      return ResponseEntity.ok(list);
   }
}
