package com.vixsys.dscommerce.dtos;

import com.vixsys.dscommerce.entities.Category;
import com.vixsys.dscommerce.entities.Product;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDto
{
   private Long id_product;
   @NotBlank(message = "Preenchimento obrigatório!")
   @Size(min = 3, max = 80, message = "Comprimento entre 3 e 80 caracteres!")
   private String name;
   @NotBlank(message = "Preenchimento obrigatório e mínimo de 10 caracteres!")
   @Size(min = 10)
   private String description;
   @NotNull(message = "Preenchimento obrigatório!")
   @Positive(message = "O preço deve ser positivo!")
   private Double priceTable;
   private String imageUri;

   @NotEmpty(message = "Escolha pelo menos uma categoria!")
   private List<CategoryDto> categories = new ArrayList<>();

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
      for (Category cat : entity.getCategories())
      {
         categories.add(new CategoryDto(cat));
      }
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

   public List<CategoryDto> getCategories()
   {
      return categories;
   }
}
