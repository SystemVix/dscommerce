package com.vixsys.dscommerce.services;

import com.vixsys.dscommerce.dtos.CategoryDto;
import com.vixsys.dscommerce.entities.Category;
import com.vixsys.dscommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService
{
   @Autowired
   private CategoryRepository repository;

   // Método para buscar todos as categorias
   @Transactional(readOnly = true)
   public List<CategoryDto> findAll()
   {
      List<Category> result = repository.findAll();
      return result.stream().map(CategoryDto::new).toList();
   }
}


