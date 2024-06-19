package com.vixsys.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_order")
public class Order
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id_order;
   @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
   private Instant moment;
   private OrderStatus status;

   @ManyToOne
   @JoinColumn(name = "client_id")
   private  User client;

   public Order () {}

   public Order(Long id_order, Instant moment, OrderStatus status)
   {
      this.id_order = id_order;
      this.moment = moment;
      this.status = status;
   }

   public Long getId_order()
   {
      return id_order;
   }

   public void setId_order(Long id_order)
   {
      this.id_order = id_order;
   }

   public Instant getMoment()
   {
      return moment;
   }

   public void setMoment(Instant moment)
   {
      this.moment = moment;
   }

   public OrderStatus getStatus()
   {
      return status;
   }

   public void setStatus(OrderStatus status)
   {
      this.status = status;
   }
}
