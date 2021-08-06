package com.example.blazetest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.blazetest.models.Product;
import com.example.blazetest.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {
  @Autowired
  ProductService productService;


  @GetMapping()
  public List<Product> getProducts(){
    return productService.getProducts();
  }

  @GetMapping(path = "/{id}")
  public Optional<Product> getProductById(@PathVariable("id") Long id){
    return productService.getById(id); 
  }

  @GetMapping("/pageable")
  public Page<Product> retrieveProductWithPaging(@Param(value = "page") int page, 
                                              @Param(value = "size") int size){
    Page<Product> products =productService.getProductsPageable(page, size);
    return products;
  }

/** This method allows to Add and Edit a Product*/
  @PostMapping()
  public Product saveProduct(@RequestBody Product product){
    return productService.saveProduct(product);
  }
  @DeleteMapping(path = "/{id}")
  public String deleteProductById(@PathVariable("id") Long id){
    boolean productDeleted = productService.deleteById(id);
    if(productDeleted) {
      return "Product id: " + id + " was deleted";
    }else{
      return "Product id: " + id + " was not deleted!";
    }
  }
}
