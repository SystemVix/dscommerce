package com.vixsys.dscommerce.services;

import com.vixsys.dscommerce.entities.Role;
import com.vixsys.dscommerce.entities.User;
import com.vixsys.dscommerce.projections.UserDetailsProjection;
import com.vixsys.dscommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService
{
   @Autowired
   private UserRepository repository;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
      if (result.isEmpty())
      {
         throw new UsernameNotFoundException("Email not found");
      }

      /*User user = repository.findByEmail(username);
      if (user == null)
      {
         throw new UsernameNotFoundException("E-mail não encontrado!");
      }*/

      User user = new User();
      user.setEmail(result.get(0).getUsername());
      user.setPassword(result.get(0).getPassword());
      for (UserDetailsProjection projection : result) {
         user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
      }

      return user;
   }
}
