package com.example.blazetest.repositories;

import com.example.blazetest.models.Order;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository <Order, Long> {

}
