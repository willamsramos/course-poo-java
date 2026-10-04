package application;

import entites.enums.OrderStatus;
import entities.Order;

import java.util.Date;

public class Program {
  static void main(String[] args) {

    Order order = new Order(1080, new Date(), OrderStatus.AGUARDANDO_PAGAMENTO);
    System.out.println(order);

    OrderStatus os1 = OrderStatus.ENTREGUE;

    OrderStatus os2 = OrderStatus.valueOf("ENTREGUE");

    System.out.println(os1);
    System.out.println(os2);

  }
}
