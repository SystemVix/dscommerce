package com.vixsys.dscommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem
{
   @EmbeddedId
   private OrderItemPK id_orderItem = new OrderItemPK();

   private Integer quantity;
   private  Double priceSale;

   public OrderItem() {}

   public OrderItem(Order order, Product product, Integer quantity, Double priceSale)
   {
      id_orderItem.setOrder(order);
      id_orderItem.setProduct(product);
      this.quantity = quantity;
      this.priceSale = priceSale;
   }

   public Order getOrder()
   {
      return id_orderItem.getOrder();
   }

   public void setOrder(Order order)
   {
      id_orderItem.setOrder(order);
   }

   public Product getProduct()
   {
      return id_orderItem.getProduct();
   }

   public void setProduct(Product product)
   {
      id_orderItem.setProduct(product);
   }

   public Integer getQuantity()
   {
      return quantity;
   }

   public void setQuantity(Integer quantity)
   {
      this.quantity = quantity;
   }

   public Double getPriceSale()
   {
      return priceSale;
   }

   public void setPriceSale(Double priceSale)
   {
      this.priceSale = priceSale;
   }
}
