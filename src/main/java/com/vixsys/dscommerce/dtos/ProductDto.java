package com.vixsys.dscommerce.dtos;

import com.vixsys.dscommerce.entities.Product;

public class ProductDto
{
   private Long id_product;
   private String name;
   private String description;
   private Double priceTable;
   private String imageUri;

   public ProductDto(Long id_product, String name, String description, Double priceTable, String imageUri)
   {
      this.id_product = id_product;
      this.name = name;
      this.description = description;
      this.priceTable = priceTable;
      this.imageUri = imageUri;
   }

   public ProductDto(Product entity)
   {
      id_product = entity.getId_product();
      name = entity.getName();
      description = entity.getDescription();
      priceTable = entity.getPriceTable();
      imageUri = entity.getImageUri();
   }

   public Long getId_product()
   {
      return id_product;
   }

   public String getName()
   {
      return name;
   }

   public String getDescription()
   {
      return description;
   }

   public Double getPriceTable()
   {
      return priceTable;
   }

   public String getImageUri()
   {
      return imageUri;
   }
}
