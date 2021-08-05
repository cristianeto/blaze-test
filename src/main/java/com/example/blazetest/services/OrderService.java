package com.example.blazetest.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.blazetest.models.Order;
import com.example.blazetest.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

  public Optional<Order> getById(Long id){
    return orderRepository.findById(id);
  }

  public Page<Order> getOrdersPageable(int page, int size){
    Pageable requestPage = PageRequest.of(page,size);
    Page<Order> orders = orderRepository.findAll(requestPage);
    return orders;
  }
  public Order saveOrder(Order order){
    if(order.getId() == null){
      order.setId(sequenceGenerator.generateSequence(Order.SEQUENCE_NAME));
    }
    return orderRepository.insert(order);
  }
}
