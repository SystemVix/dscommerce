package com.vixsys.dscommerce.entities;

import javax.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

   // ASSOCIAÇÕES
   @ManyToOne
   @JoinColumn(name = "client_id")
   private  User client;
   @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
   private Payment payment;
   @OneToMany(mappedBy = "id_orderItem.order")
   private Set<OrderItem> items = new HashSet<>();

   public Order () {}

   public Order(Long id_order, Instant moment, OrderStatus status, User client, Payment payment)
   {
      this.id_order = id_order;
      this.moment = moment;
      this.status = status;
      this.client = client;
      this.payment = payment;
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

   public User getClient()
   {
      return client;
   }

   public void setClient(User client)
   {
      this.client = client;
   }

   public Payment getPayment()
   {
      return payment;
   }

   public void setPayment(Payment payment)
   {
      this.payment = payment;
   }

   public Set<OrderItem> getItems()
   {
      return items;
   }

   public List<Product> getProducts()
   {
      return items.stream().map(OrderItem::getProduct).toList();
      // (OrderItem::getProduct) corresponde a (x -> x.getProduct())
   }

   @Override
   public boolean equals(Object o)
   {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Order order = (Order) o;
      return Objects.equals(id_order, order.id_order);
   }

   @Override
   public int hashCode()
   {
      return Objects.hashCode(id_order);
   }
}
