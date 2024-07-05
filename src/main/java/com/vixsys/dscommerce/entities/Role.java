package com.vixsys.dscommerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_role")
public class Role
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id_role;
   private String authority;

   public Role() {}

   public Role(Long id, String authority)
   {
      this.id_role = id_role;
      this.authority = authority;
   }

   public Long getId()
   {
      return id_role;
   }

   public void setId(Long id)
   {
      this.id_role = id;
   }

   public String getAuthority()
   {
      return authority;
   }

   public void setAuthority(String authority)
   {
      this.authority = authority;
   }
}
