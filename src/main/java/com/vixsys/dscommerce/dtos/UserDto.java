package com.vixsys.dscommerce.dtos;

import com.vixsys.dscommerce.entities.User;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDto
{
   private Long id;
   private String name;
   private String email;
   private String phone;
   private LocalDate birthDate;
   private List<String> roles = new ArrayList<>();

   public UserDto(Long id, String name, String email, String phone, LocalDate birthDate)
   {
      this.id = id;
      this.name = name;
      this.email = email;
      this.phone = phone;
      this.birthDate = birthDate;
   }

   public UserDto(User entity)
   {
      id = entity.getId_user();
      name = entity.getName();
      email = entity.getEmail();
      phone = entity.getPhone();
      birthDate = entity.getBirthDate();
      for (GrantedAuthority role : entity.getAuthorities())
      {
         roles.add(role.getAuthority());
      }
   }

   public Long getId()
   {
      return id;
   }

   public String getName()
   {
      return name;
   }

   public String getEmail()
   {
      return email;
   }

   public String getPhone()
   {
      return phone;
   }

   public LocalDate getBirthDate()
   {
      return birthDate;
   }

   public List<String> getRoles()
   {
      return roles;
   }
}
