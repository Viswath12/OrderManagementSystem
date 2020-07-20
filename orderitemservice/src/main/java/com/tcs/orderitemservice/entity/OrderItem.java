package com.tcs.orderitemservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "order_items")
public class OrderItem implements Serializable {
  
  /**
   * default value for serial version uid
   */
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  @Column(name = "order_id")
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
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OrderItem other = (OrderItem) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}