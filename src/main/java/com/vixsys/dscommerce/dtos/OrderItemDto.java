package com.vixsys.dscommerce.dtos;

import com.vixsys.dscommerce.entities.OrderItem;
import com.vixsys.dscommerce.entities.Product;

public class OrderItemDto
{
   private Long productId;
   private String name;
   private Double price;
   private Integer quantity;

   public OrderItemDto(Long productId, String name, Double price, Integer quantity)
   {
      this.productId = productId;
      this.name = name;
      this.price = price;
      this.quantity = quantity;
   }

   public OrderItemDto(OrderItem entity)
   {
      productId = entity.getProduct().getId_product();
      name = entity.getProduct().getName();
      price = entity.getPriceSale();
      quantity = entity.getQuantity();
   }

   public Long getProductId()
   {
      return productId;
   }

   public String getName()
   {
      return name;
   }

   public Double getPrice()
   {
      return price;
   }

   public Integer getQuantity()
   {
      return quantity;
   }

   public Double getSubTotal()
   {
      return price * quantity;
   }
}
