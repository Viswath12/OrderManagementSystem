package com.tcs.orderservice.rest.error;

import java.net.URI;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class InvalidOrderItemsInOrderException extends AbstractThrowableProblem {
  
  /**
   * default value for serial version uid
   */
  private static final long serialVersionUID = 1L;
  
  private static final URI TYPE = URI.create("http://orderservice.tcs.com/save");

  public InvalidOrderItemsInOrderException(String msg) {
      super(TYPE, "Bad Request", Status.BAD_REQUEST, msg);
  }
}