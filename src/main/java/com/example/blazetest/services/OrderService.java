package com.example.blazetest.services;

import java.util.ArrayList;

import com.example.blazetest.models.Order;
import com.example.blazetest.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
  @Autowired
  OrderRepository orderRepository;
  @Autowired
  SequenceGeneratorService sequenceGenerator;

  public ArrayList<Order> getOrders(){
    return (ArrayList<Order>) orderRepository.findAll();
  }

  public Order saveOrder(Order order){
    if(order.getId() == null){
      order.setId(sequenceGenerator.generateSequence(Order.SEQUENCE_NAME));
    }
    return orderRepository.insert(order);
  }
}
