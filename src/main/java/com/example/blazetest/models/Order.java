package com.example.blazetest.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.blazetest.utils.Utils;

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

  private Double subtotal=0.0;
  private Double subtotalAux=0.0;
  private Double cityTax=0.0;
  private Double countyTax=0.0;
  private Double stateTax=0.0;
  private Double federalTax=0.0;
  private Double totalTaxes=0.0;
  private Double total=0.0;

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

  public Double getSubtotal() {
    //Double subtotal = 0.0;
    for (Product product : this.products) {
      this.subtotal += product.getUnitPrice();
    }
    return this.subtotal;
  }

  public Double getCityTax(){    
    this.cityTax = Utils.RoundToTwoDecimalPlaces(this.subtotal * 0.1);
    this.subtotalAux = this.subtotal + this.cityTax;    
    return this.cityTax;
  }
  
  public Double getCountyTax(){    
    this.countyTax = this.subtotalAux * 0.05;
    this.countyTax = Utils.RoundToTwoDecimalPlaces(this.countyTax);
    this.subtotalAux = this.subtotalAux + this.cityTax;
    return this.countyTax;
  }
  
  public Double getStateTax(){    
    this.stateTax = this.subtotalAux * 0.08;
    this.stateTax = Utils.RoundToTwoDecimalPlaces(this.stateTax);
    this.subtotalAux = this.subtotalAux + this.countyTax;
    return this.stateTax;
  }
  
  public Double getFederalTax(){    
    this.federalTax = this.subtotalAux * 0.02;
    this.federalTax =Utils.RoundToTwoDecimalPlaces(this.federalTax);
    this.subtotalAux = this.subtotalAux + this.stateTax;
    return this.federalTax;
  }
  
  public Double getTotalTaxes(){
    this.totalTaxes = this.cityTax + this.countyTax +
                     this.stateTax + this.federalTax;
    this.totalTaxes = Utils.RoundToTwoDecimalPlaces(this.totalTaxes);
    return this.totalTaxes;
  }
  public Double getTotal(){
    this.total = this.subtotal+ this.totalTaxes;
    this.total = Utils.RoundToTwoDecimalPlaces(this.total);
    return this.total;
  }
}
