package application;

import entities.Client;
import entities.Order2;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program03 {
  public static void main(String[] args) throws ParseException {

    Locale.setDefault(Locale.US);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false);

    Scanner sc = new Scanner(System.in);

    System.out.println("Insira os dados do cliente:");
    System.out.print("Nome: ");
    String name = sc.nextLine();

    System.out.print("Email: ");
    String email = sc.nextLine();

    System.out.print("Data de nascimento (DD/MM/YYYY): ");
    Date birthDate = sdf.parse(sc.nextLine().trim());

    Client client = new Client(name, email, birthDate);

    System.out.println("Digite os dados do pedido:");
    System.out.print("Status: ");
    OrderStatus2 status = OrderStatus2.valueOf(sc.nextLine().trim().toUpperCase());

    Order2 order = new Order2(client, status, new Date());

    System.out.print("Quantos itens o pedido vai ter? ");
    int itemCount = sc.nextInt();
    sc.nextLine();

    for (int i = 1; i <= itemCount; i++) {
      System.out.println("Digite #" + i + " os dados do item:");

      System.out.print("Nome do produto: ");
      String productName = sc.nextLine();

      System.out.print("Preco do produto: ");
      double productPrice = sc.nextDouble();

      System.out.print("Quantidade: ");
      int quantity = sc.nextInt();
      sc.nextLine();

      Product product = new Product(productName, productPrice);
      OrderItem orderItem = new OrderItem(quantity, productPrice, product);
      order.addItem(orderItem);
    }

    System.out.println();
    System.out.println("RESUMO DO PEDIDO:");
    System.out.println(order);

    sc.close();
  }
}
