package com.tcs.orderservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.orderservice.entity.Order;
import com.tcs.orderservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
  
  @Autowired
  private OrderRepository orderRepository;

  @Override
  @Transactional(readOnly = true)
  public Optional<Order> findById(Long id) {
    LOGGER.info("Request to find order by id==[{}].", id);
    return orderRepository.findById(id);
  }

  @Override
  public Order save(Order order) {
    LOGGER.info("Request to save order==[{}].", order);
    return orderRepository.saveAndFlush(order);
  }
}