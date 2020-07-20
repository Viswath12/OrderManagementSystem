package com.tcs.orderservice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
  
  /**
   * default value for serial version uid
   */
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  @Column(name = "customer_name")
  private String customerName;
  @NotNull
  @Column(name = "order_date")
  private LocalDateTime orderDate;
  @NotBlank
  @Column(name = "shipping_address")
  private String address;
  private BigDecimal total;
  
  @Transient
  @NotEmpty
  private List<@Valid OrderItem> orderItems;
  
  public Order() {
    orderItems = new ArrayList<>();
  }
  
  public Long getId() {
    return id;
  }
  public Order setId(Long id) {
    this.id = id;
    return this;
  }
  
  public String getCustomerName() {
    return customerName;
  }
  public Order setCustomerName(String customerName) {
    this.customerName = customerName;
    return this;
  }
  
  public LocalDateTime getOrderDate() {
    return orderDate;
  }
  public Order setOrderDate(LocalDateTime orderDate) {
    this.orderDate = orderDate;
    return this;
  }
  
  public String getAddress() {
    return address;
  }
  public Order setAddress(String address) {
    this.address = address;
    return this;
  }
  
  public BigDecimal getTotal() {
    return total;
  }
  public Order setTotal(BigDecimal total) {
    this.total = total;
    return this;
  }
  
  public List<OrderItem> getOrderItems() {
    return orderItems;
  }
  public Order setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
    return this;
  }
  public Order addOrderItemToOrder(OrderItem orderItem) {
    this.getOrderItems().add(orderItem);
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
    Order other = (Order) obj;
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