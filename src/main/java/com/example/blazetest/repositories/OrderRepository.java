package com.example.blazetest.repositories;

import com.example.blazetest.models.Order;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository <Order, Long> {

}
