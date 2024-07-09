package com.vixsys.dscommerce.dtos;

import com.vixsys.dscommerce.entities.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ProductMinDto
{
   private Long id_product;
   private String name;
   private Double priceTable;
   private String imageUri;

   public ProductMinDto(Long id_product, String name, Double priceTable, String imageUri)
   {
      this.id_product = id_product;
      this.name = name;
      this.priceTable = priceTable;
      this.imageUri = imageUri;
   }

   public ProductMinDto(Product entity)
   {
      id_product = entity.getId_product();
      name = entity.getName();
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

   public Double getPriceTable()
   {
      return priceTable;
   }

   public String getImageUri()
   {
      return imageUri;
   }
}
