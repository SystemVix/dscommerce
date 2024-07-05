package com.vixsys.dscommerce.entities;

import javax.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_payment")
public class Payment
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id_payment;
   @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
   private Instant moment;

   @OneToOne
   @MapsId
   private Order order;

   public Payment() {}

   public Payment(Long id_payment, Instant moment, Order order)
   {
      this.id_payment = id_payment;
      this.moment = moment;
      this.order = order;
   }

   public Long getId_payment()
   {
      return id_payment;
   }

   public void setId_payment(Long id_payment)
   {
      this.id_payment = id_payment;
   }

   public Instant getMoment()
   {
      return moment;
   }

   public void setMoment(Instant moment)
   {
      this.moment = moment;
   }

   public Order getOrder()
   {
      return order;
   }

   public void setOrder(Order order)
   {
      this.order = order;
   }
}
