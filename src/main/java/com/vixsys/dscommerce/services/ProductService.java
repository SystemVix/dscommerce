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

   // Método para buscar um item por ID
   @Transactional(readOnly = true)
   public ProductDto findById(Long id)
   {
      Product product = repository.findById(id).get();
      return new ProductDto(product);
   }

   // Método para buscar todos os itens
   @Transactional(readOnly = true)
   public Page<ProductDto> findAll(Pageable pageable)
   {
      Page<Product> result = repository.findAll(pageable);
      return result.map(ProductDto::new);
      // Código do professor: return result.map(x -> new ProductDto(x));
   }

   // Método auxiliar para copiar os dados do Dto para o Entity
   private void copyDtoToEntity(ProductDto dto, Product entity)
   {
      entity.setName(dto.getName());
      entity.setDescription(dto.getDescription());
      entity.setPriceTable(dto.getPriceTable());
      entity.setImageUri(dto.getImageUri());
   }

   // Método para inserir um novo item
   @Transactional
   public ProductDto insert(ProductDto dto)
   {
      Product entity = new Product();
      copyDtoToEntity(dto, entity);
      entity = repository.save(entity);
      return new ProductDto(entity);
   }

   // Método para atualizar um item
   @Transactional
   public ProductDto update(Long id, ProductDto dto)
   {
      Product entity = repository.getReferenceById(id);
      copyDtoToEntity(dto, entity);
      entity = repository.save(entity);
      return new ProductDto(entity);
   }
}
