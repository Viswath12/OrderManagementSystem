package com.tcs.orderitemservice.service;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.orderitemservice.entity.OrderItem;
import com.tcs.orderitemservice.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(OrderItemServiceImpl.class);
  
  @Autowired
  private OrderItemRepository orderItemRepository;

  @Override
  @Transactional(readOnly = true)
  public List<OrderItem> findAll() {
    LOGGER.info("Request to find all orderitems");
    return orderItemRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<OrderItem> findById(Long id) {
    LOGGER.info("Request to find orderitem by id==[{}].", id);
    return orderItemRepository.findById(id);
  }
  
  @Override
  @Transactional(readOnly = true)
  public List<OrderItem> findByOrderId(Long orderId) {
    LOGGER.info("Request to find orderitem by orderId==[{}].", orderId);
    return orderItemRepository.findByOrderId(orderId);
  }

  @Override
  @Transactional
  public OrderItem save(OrderItem item) {
    LOGGER.info("Request to save orderitem item==[{}].", item);
    return orderItemRepository.saveAndFlush(item);
  }
}