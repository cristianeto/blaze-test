package com.example.blazetest.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {
  
  @Transient
  public static final String SEQUENCE_NAME = "orders_sequence";

  @Id
  private long id;
  private String status; 
  private Date createdAt; 
  private String customer;
  private Product[] product; 

  public Order(){}

  public Order(String status, Date createdAt, String customer, Product[] product) {
    this.status = status;
    this.createdAt = createdAt;
    this.customer = customer;
    this.product = product;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public Product[] getProduct() {
    return product;
  }

  public void setProduct(Product[] product) {
    this.product = product;
  }

  
}
