package com.vixsys.dscommerce.dtos;

import com.vixsys.dscommerce.entities.Category;

public class CategoryDto
{
   private Long id;
   private String name;

   public CategoryDto(Long id, String name)
   {
      this.id = id;
      this.name = name;
   }

   public CategoryDto(Category entity)
   {
      id = entity.getId_category();
      name = entity.getName();
   }

   public Long getId()
   {
      return id;
   }

   public String getName()
   {
      return name;
   }
}
