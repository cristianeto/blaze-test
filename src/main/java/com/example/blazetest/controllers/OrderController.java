package com.example.blazetest.controllers;

import java.util.ArrayList;

import com.example.blazetest.models.Order;
import com.example.blazetest.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
  public ArrayList<Order> getOrders(){
    return orderService.getOrders();
  }

  @PostMapping()
  public Order saveOrder(@RequestBody Order order){
    return orderService.saveOrder(order);
  }
}
