package com.tcs.orderservice.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tcs.orderservice.clients.OrderItemServiceClient;
import com.tcs.orderservice.entity.Order;
import com.tcs.orderservice.entity.OrderItem;
import com.tcs.orderservice.rest.error.InvalidOrderItemsInOrderException;
import com.tcs.orderservice.rest.error.OrderNotFoundException;
import com.tcs.orderservice.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
  
  @Autowired
  private OrderService orderService;
  
  @Autowired
  private OrderItemServiceClient orderItemServiceClient;
  
  @GetMapping("/{id}")
  public ResponseEntity<Order> getById(@PathVariable Long id) {
    LOGGER.info("REST request to get order by id==[{}].", id);
    Optional<Order> optOrder = orderService.findById(id);
    if(!optOrder.isPresent()) {
      throw new OrderNotFoundException(id);
    }
    Order order = optOrder.get();
    List<OrderItem> orderItems = orderItemServiceClient.getByOrderId(id);
    order.setOrderItems(orderItems);
    return new ResponseEntity<>(order, HttpStatus.OK);
  }
  
  @PostMapping("/save")
  public ResponseEntity<Order> saveOrder(@Valid @RequestBody Order order) {
    LOGGER.info("REST request to save order==[{}].", order);
    if(order.getId() != null ) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    if( CollectionUtils.isEmpty(order.getOrderItems()) ) {
      throw new InvalidOrderItemsInOrderException("Order donot have any orderItems.");
    }
    boolean hasId = order.getOrderItems().stream().anyMatch( item -> item.getId() != null);
    if( hasId ) {
      throw new InvalidOrderItemsInOrderException("OrderItem in Order should not have id.");
    }
    Order savedOrder = orderService.save(order);
    LOGGER.info("Saved order successfully. Saving orderItems.");
    Long orderId = savedOrder.getId();
    List<OrderItem> orderItems = new ArrayList<>();
    for(OrderItem orderItem: order.getOrderItems()) {
      orderItems.add(orderItemServiceClient.saveOrderItem(orderItem.setOrderId(orderId)));
    }
    savedOrder.setOrderItems(orderItems);
    LOGGER.info("Saved order with orderItems successfully.");
    return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
  }

}