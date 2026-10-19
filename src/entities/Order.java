package entities;

import entities.enums.OrderStatus;

import java.util.Date;

public class Order {

  private Integer id;
  private Date momento;
  private OrderStatus status;

  public Order() {
  }

  public Order(Integer id, Date momento, OrderStatus status) {
    this.id = id;
    this.status = status;
    this.momento = momento;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getMomento() {
    return momento;
  }

  public void setMomento(Date momento) {
    this.momento = momento;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Order{" +
            "id=" + id +
            ", momento=" + momento +
            ", status=" + status +
            '}';
  }
}
