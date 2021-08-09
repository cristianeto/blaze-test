package com.example.blazetest.models;

import com.example.blazetest.utils.Utils;
import com.mongodb.lang.NonNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
  @Transient
  public static final String SEQUENCE_NAME = "products_sequence";
  
  @Id
  private Long id; 
  @NonNull
  private String name;
  private String category;
  @NonNull
  private Double unitPrice;
  @NonNull
  private Boolean isActive;
  @NonNull
  private int quantity;
  private Double cost;

  public Product(){}
  

  public Product(String name, String category, Double unitPrice, Boolean isActive, int quantity, Double cost) {
    this.name = name;
    this.category = category;
    this.unitPrice = unitPrice;
    this.isActive = isActive;
    this.quantity = quantity;
    this.cost = cost;
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

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Double getCost() {
    return Utils.RoundToTwoDecimalPlaces((this.quantity * this.unitPrice));
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }
}
