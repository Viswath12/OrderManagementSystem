package com.tcs.orderservice.clients;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tcs.orderservice.entity.OrderItem;

@FeignClient("orderitemservice")
public interface OrderItemServiceClient {
  
  @RequestMapping(method= RequestMethod.GET, value="/orderitems/order/{orderId}", consumes="application/json")
  List<OrderItem> getByOrderId(@PathVariable Long orderId);
  
  @RequestMapping(method= RequestMethod.GET, value="/orderitems/save", consumes = "application/json", produces = "application/json")
  OrderItem saveOrderItem(@Valid @RequestBody OrderItem item);
}