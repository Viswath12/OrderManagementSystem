package com.tcs.orderservice.rest.error;

import java.net.URI;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class OrderNotFoundException extends AbstractThrowableProblem {
  
  /**
   * default value for serial version uid
   */
  private static final long serialVersionUID = 1L;
  
  private static final URI TYPE = URI.create("http://orderservice.tcs.com/order-not-found");

  public OrderNotFoundException(Long orderId) {
      super(TYPE, "Not found", Status.NOT_FOUND, String.format("Order with id==[%s] not found", orderId));
  }
}