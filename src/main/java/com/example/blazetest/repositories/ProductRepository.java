package com.example.blazetest.repositories;

import java.util.Optional;

import com.example.blazetest.models.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository <Product, Long> {
  public abstract Optional<Product> findByName(String name);
  
  Slice<Product> findAllByName(String name, Pageable pageable);
  Page<Product> findAllByUnitPriceGreaterThan(Double unitPrice, Pageable pageable);

}