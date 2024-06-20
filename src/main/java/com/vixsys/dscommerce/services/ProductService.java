package com.vixsys.dscommerce.services;

import com.vixsys.dscommerce.dtos.ProductDto;
import com.vixsys.dscommerce.entities.Product;
import com.vixsys.dscommerce.repositories.ProductRepository;
import jakarta.annotation.Nonnull;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService
{
   @Autowired
   private ProductRepository repository;

   @Transactional(readOnly = true)
   public ProductDto findById(Long id)
   {
      Product product = repository.findById(id).get();
      return new ProductDto(product);
   }
}
