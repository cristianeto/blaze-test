package com.example.blazetest.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {
  
  @Transient
  public static final String SEQUENCE_NAME = "orders_sequence";

  @Id
  private Long id;
  @Indexed(direction = IndexDirection.ASCENDING)
  private String status; 
  private Date createdAt; 
  private String customer;
  private List<Product> products; 

  public Order(){}

  public Order(String status, Date createdAt, String customer, List<Product> products) {
    this.status = status;
    this.createdAt = createdAt;
    this.customer = customer;
    this.products = products;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

/*   @Override
  public String toString() {
   StringBuilder builder = new StringBuilder();
   builder.append("Order [id=").append(id).append(", status=").append(status).append(", createAt=")
     .append(createdAt).append(", customer=")
     .append(customer).append(", products=")
     .append(products).append("]");
   return builder.toString();
  } */
}
