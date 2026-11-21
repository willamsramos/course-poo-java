package entities;

import entities.enums.OrderStatus2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order2 {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date moment;
    private OrderStatus2 status2;
    private Client client;

    private final List<OrderItem> items = new ArrayList<>();

    public Order2() {
    }

    public Order2(Client client, OrderStatus2 status2, Date moment) {
        this.client = client;
        this.status2 = status2;
        this.moment = moment;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus2 getStatus2() {
        return status2;
    }

    public void setStatus2(OrderStatus2 status2) {
        this.status2 = status2;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public double total() {
        double sum = 0.0;
        for (OrderItem item : items) {
            sum += item.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Order moment: ");
        sb.append(moment == null ? "not set" : sdf.format(moment)).append("\n");

        sb.append("Order status: ");
        sb.append(status2 == null ? "not set" : status2).append("\n");

        sb.append("Client: ");
        sb.append(client == null ? "not set" : client).append("\n");

        sb.append("Order items:\n");
        for (OrderItem item : items) {
            sb.append(item).append("\n");
        }

        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));

        return sb.toString();
    }
}