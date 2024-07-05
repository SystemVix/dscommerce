package com.vixsys.dscommerce.entities;

import javax.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "tb_role")
public class Role implements GrantedAuthority
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id_role;
   private String authority;

   public Role() {}

   public Role(Long id_role, String authority)
   {
      this.id_role = id_role;
      this.authority = authority;
   }

   public Long getId_role()
   {
      return id_role;
   }

   public void setId_role(Long id_role)
   {
      this.id_role = id_role;
   }

   @Override
   public String getAuthority()
   {
      return authority;
   }

   public void setAuthority(String authority)
   {
      this.authority = authority;
   }
}
