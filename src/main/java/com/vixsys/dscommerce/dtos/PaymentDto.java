package com.vixsys.dscommerce.dtos;

import com.vixsys.dscommerce.entities.Payment;

import java.time.Instant;

public class PaymentDto
{
   private Long id;
   private Instant moment;

   public PaymentDto(Long id, Instant moment)
   {
      this.id = id;
      this.moment = moment;
   }

   public PaymentDto(Payment entity)
   {
      id = entity.getId_payment();
      moment = entity.getMoment();
   }

   public Long getId()
   {
      return id;
   }

   public Instant getMoment()
   {
      return moment;
   }
}
