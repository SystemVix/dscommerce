package com.vixsys.dscommerce.controllers;

import com.vixsys.dscommerce.dtos.CategoryDto;
import com.vixsys.dscommerce.dtos.ProductDto;
import com.vixsys.dscommerce.dtos.ProductMinDto;
import com.vixsys.dscommerce.services.CategoryService;
import com.vixsys.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
