package com.example.blazetest.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import com.example.blazetest.models.Product;
import com.example.blazetest.repositories.ProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ProductServiceTest {

  @Mock
  ProductRepository productRepository;

  @InjectMocks
  ProductService productService;

  private Product product;

  @BeforeEach
  void setUp(){
    MockitoAnnotations.initMocks(this);

    product = new Product(); 
    // product.setId(Long.valueOf(1));
    product.setName("Martini");
    product.setCategory("Cakes");
    product.setUnitPrice(2.90);
    product.setIsActive(true);
  }

  @Test
  void testGetProducts() {
     when(productRepository.findAll()).thenReturn(Arrays.asList(product));
    assertNotNull(productService.getProducts()); 
  }
}
