package com.tcs.orderitemservice.service;

import java.util.List;
import java.util.Optional;

import com.tcs.orderitemservice.entity.OrderItem;

public interface OrderItemService {
  
  List<OrderItem> findAll();
  Optional<OrderItem> findById(Long id);
  List<OrderItem> findByOrderId(Long orderId);
  OrderItem save(OrderItem item);
}