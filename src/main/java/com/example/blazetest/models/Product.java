package com.example.blazetest.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
  @Transient
  public static final String SEQUENCE_NAME = "products_sequence";

  @Id
  private Long id; 
  private String name;
  private String category;
  private Double unitPrice;
  private Boolean isActive;

  public Product(){}
  
  public Product(String name, String category, Double unitPrice, Boolean isActive) {
    this.name = name;
    this.category = category;
    this.unitPrice = unitPrice;
    this.isActive = isActive;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }
}
