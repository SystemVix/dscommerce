package com.vixsys.dscommerce.services;

import com.vixsys.dscommerce.dtos.CategoryDto;
import com.vixsys.dscommerce.dtos.ProductDto;
import com.vixsys.dscommerce.dtos.ProductMinDto;
import com.vixsys.dscommerce.entities.Category;
import com.vixsys.dscommerce.entities.Product;
import com.vixsys.dscommerce.repositories.ProductRepository;
import com.vixsys.dscommerce.services.exceptions.DatabaseException;
import com.vixsys.dscommerce.services.exceptions.ResourceNotFoundException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService
{
   @Autowired
   private ProductRepository repository;

   // Método para buscar um item por ID
   @Transactional(readOnly = true)
   public ProductDto findById(Long id)
   {
      Product product = repository.findById(id).orElseThrow
         (() -> new ResourceNotFoundException("Recurso não encontrado!"));
      return new ProductDto(product);
   }

   // Método para buscar todos os itens
   @Transactional(readOnly = true)
   public Page<ProductMinDto> findAll(String name, Pageable pageable)
   {
      Page<Product> result = repository.searchByName(name, pageable);
      return result.map(ProductMinDto::new);
      // Código do professor: return result.map(x -> new ProductDto(x));
   }

   // Método auxiliar para copiar os dados do Dto para o Entity
   private void copyDtoToEntity(ProductDto dto, Product entity)
   {
      entity.setName(dto.getName());
      entity.setDescription(dto.getDescription());
      entity.setPriceTable(dto.getPriceTable());
      entity.setImageUri(dto.getImageUri());
      entity.getCategories().clear();
      for (CategoryDto catDto : dto.getCategories())
      {
         Category cat = new Category();
         cat.setId_category(catDto.getId());
         entity.getCategories().add(cat);
      }
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
      try
      {
         Product entity = repository.getReferenceById(id);
         copyDtoToEntity(dto, entity);
         entity = repository.save(entity);
         return new ProductDto(entity);
      }
      catch (EntityNotFoundException e)
      {
         throw new ResourceNotFoundException("Recurso não encontrado!");
      }
   }

   // Método para excluir um item
   @Transactional(propagation = Propagation.SUPPORTS)
   public void delete(Long id)
   {
      try
      {
         repository.deleteById(id);
      }
      catch (EmptyResultDataAccessException e)
      {
         throw new ResourceNotFoundException("Recurso não encontrado!");
      }
      catch (DataIntegrityViolationException e)
      {
         throw new DatabaseException("Falha de integridade referencial!");
      }
   }
}


