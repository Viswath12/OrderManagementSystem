package com.tcs.orderitemservice.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.orderitemservice.entity.OrderItem;
import com.tcs.orderitemservice.service.OrderItemService;

@RestController
@RequestMapping(value = "/orderitems")
public class OrderItemController {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(OrderItemController.class);
  
  @Autowired
  private OrderItemService orderItemService;
  
  @GetMapping("/")
  public ResponseEntity<List<OrderItem>> getAll() {
    LOGGER.info("REST request to get all orderitems.");
    List<OrderItem> items = orderItemService.findAll();
    return new ResponseEntity<>(items, HttpStatus.OK);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<OrderItem> getById(@PathVariable Long id) {
    LOGGER.info("REST request to get orderitem by id==[{}].", id);
    Optional<OrderItem> optOrderItem = orderItemService.findById(id);
    if(optOrderItem.isPresent()) {
      return new ResponseEntity<>(optOrderItem.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @GetMapping("/order/{orderId}")
  public ResponseEntity<List<OrderItem>> getByOrderId(@PathVariable Long orderId) {
    LOGGER.info("REST request to get orderitem by orderId==[{}].", orderId);
    List<OrderItem> items = orderItemService.findByOrderId(orderId);
    return new ResponseEntity<>(items, HttpStatus.OK);
  }
  
  @PostMapping("/save")
  public ResponseEntity<OrderItem> saveOrderItem(@Valid @RequestBody OrderItem item) {
    LOGGER.info("REST request to save orderitem by item==[{}].", item);
    if(item.getId() != null) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    item = orderItemService.save(item);
    return new ResponseEntity<>(item, HttpStatus.CREATED);
  }
}