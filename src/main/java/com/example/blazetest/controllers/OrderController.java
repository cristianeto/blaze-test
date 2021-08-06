package com.example.blazetest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.blazetest.models.Order;
import com.example.blazetest.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
  @Autowired
  OrderService orderService;

  @GetMapping()
  public List<Order> getOrders(){
    return orderService.getOrders();
  }

  @GetMapping(path = "/{id}")
  public Optional<Order> getOrderById(@PathVariable("id") Long id){
    return orderService.getById(id); 
  }

  @GetMapping("/pageable")
  public Page<Order> retrieveOrderWithPaging(@Param(value = "page") int page, 
                                              @Param(value = "size") int size){
    Page<Order> orders =orderService.getOrdersPageable(page, size);
    return orders;
  }
  @PostMapping()
  public Order saveOrder(@RequestBody Order order){
    return orderService.saveOrder(order);
  }

  @DeleteMapping(path = "/{id}")
  public String deleteOrderById(@PathVariable("id") Long id){    
    boolean orderDeleted = orderService.deleteById(id);
    if(orderDeleted) {
      return "Order id: " + id + " was deleted";
    }else{
      return "Order id: " + id + " was not deleted or doesn't exist!";
    }
  }
}
