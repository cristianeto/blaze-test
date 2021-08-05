package com.example.blazetest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.blazetest.models.Product;
import com.example.blazetest.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  @Autowired
  ProductRepository productRepository;
  @Autowired
  SequenceGeneratorService sequenceGenerator;

  public List<Product> getProducts(){
    return productRepository.findAll();
  }
  public Optional<Product> getById(Long id){
    return productRepository.findById(id);
  }

  public Page<Product> getProductsPageable(int page, int size){
    Pageable requestPage = PageRequest.of(page,size);
    Page<Product> products = productRepository.findAll(requestPage);
    return products;
  }

  public Product saveProduct(Product product){
    // Optional<Product> productOptional =productRepository.findByName(product.getName());
    // if(productOptional.isPresent()){
    //   throw new IllegalStateException("name has already been taken!");
    // }
    if(product.getId() == null){
      product.setId(sequenceGenerator.generateSequence(Product.SEQUENCE_NAME));
    }
    return productRepository.save(product);
  }

  public boolean deleteById(Long id){
    try {     
      productRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
