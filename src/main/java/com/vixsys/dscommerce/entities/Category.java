package com.vixsys.dscommerce.entities;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_category")
public class Category
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id_category;
   private String name;

   @ManyToMany(mappedBy = "categories")
   private Set<Product> products = new HashSet<>();

   public Category() {}

   public Category(Long id_category, String name)
   {
      this.id_category = id_category;
      this.name = name;
   }

   public Long getId_category()
   {
      return id_category;
   }

   public void setId_category(Long id_category)
   {
      this.id_category = id_category;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Set<Product> getProducts()
   {
      return products;
   }
}
