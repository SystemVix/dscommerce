package com.vixsys.dscommerce.services;

import com.vixsys.dscommerce.dtos.ProductDto;
import com.vixsys.dscommerce.entities.Product;
import com.vixsys.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

   @Transactional(readOnly = true)
   public Page<ProductDto> findAll(Pageable pageable)
   {
      Page<Product> result = repository.findAll(pageable);
      return result.map(ProductDto::new);
      // Código do professor: return result.map(x -> new ProductDto(x));
   }
}
