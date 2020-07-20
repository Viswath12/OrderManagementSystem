package com.tcs.orderservice.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OrderItem implements Serializable {
  
  /**
   * default value for serial version uid
   */
  private static final long serialVersionUID = 1L;
  
  private Long id;
  @NotNull
  private Long orderId;
  @NotBlank
  private String code;
  @NotBlank
  private String name;
  private Integer quantity;
  
  public Long getId() {
    return id;
  }
  public OrderItem setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getOrderId() {
    return orderId;
  }
  public OrderItem setOrderId(Long orderId) {
    this.orderId = orderId;
    return this;
  }
  
  public String getCode() {
    return code;
  }
  public OrderItem setCode(String code) {
    this.code = code;
    return this;
  }

  public String getName() {
    return name;
  }
  public OrderItem setName(String name) {
    this.name = name;
    return this;
  }

  public Integer getQuantity() {
    return quantity;
  }
  public OrderItem setQuantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}