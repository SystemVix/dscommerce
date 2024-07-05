package com.vixsys.dscommerce.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig
{
   // @Bean para registrar um componente que não é seu
   @Bean
   BCryptPasswordEncoder bCriptyPasswordEncoder()
   {
      return new BCryptPasswordEncoder();
   }

   @Bean
   SecurityFilterChain filterChain(HttpSecurity http) throws Exception
   {
      http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
      http.headers().frameOptions().disable();
      http.csrf().disable();
      return http.build();
   }
}