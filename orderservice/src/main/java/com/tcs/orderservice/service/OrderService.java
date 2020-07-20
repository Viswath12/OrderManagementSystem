package com.tcs.orderservice.service;

import java.util.Optional;

import com.tcs.orderservice.entity.Order;

public interface OrderService {
  
  Optional<Order> findById(Long id);
  Order save(Order order);
}