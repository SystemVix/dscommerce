package com.vixsys.dscommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id_product;
   private String name;
   @Column(columnDefinition = "TEXT")
   private String description;
   private Double priceTable;
   private String imageUri;

   @ManyToMany
   @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id"))
   private Set<Category> categories = new HashSet<>();

   public Product() {}

   public Product(Long id_product, String name, String description, Double priceTable, String imageUri)
   {
      this.id_product = id_product;
      this.name = name;
      this.description = description;
      this.priceTable = priceTable;
      this.imageUri = imageUri;
   }

   public Long getId_product()
   {
      return id_product;
   }

   public void setId_product(Long id_product)
   {
      this.id_product = id_product;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public Double getPriceTable()
   {
      return priceTable;
   }

   public void setPriceTable(Double priceTable)
   {
      this.priceTable = priceTable;
   }

   public String getImageUri()
   {
      return imageUri;
   }

   public void setImageUri(String imageUri)
   {
      this.imageUri = imageUri;
   }

   public Set<Category> getCategories()
   {
      return categories;
   }
}
