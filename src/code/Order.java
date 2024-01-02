package code;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Order {

    static Set<Order> orders = new HashSet<>();

    Date date;
    Group group;
    Set<OrderProduct> orderProducts;
    double totalPrice;

    /**
     * Default constructor of an order
     * @param date Date when order was created
     * @param group code.Group which created the order
     * @param orderProducts Set containing all related products and their quantities
     */
    public Order(Date date, Group group, Set<OrderProduct> orderProducts) {
        this.date = date;
        this.group = group;
        this.orderProducts = orderProducts;
        totalPrice = 0;
        for (OrderProduct orderProduct : orderProducts) {
            totalPrice += (double) orderProduct.getQuantity() * orderProduct.getProduct().getPrice();
        }

        orders.add(this);
    }

    /**
     * Sends info to the restaurant about placed order
     */
    public void sendTheOrder() {
        orders.add(this);
    }

    /**
     * Allows finding all orders in which a given user took part in
     * @param user code.User for which orders are found
     * @return Set of orders made by that user
     */
    static Set<Order> checkOrderHistory(User user) {
        Set<Order> result = new HashSet<>();
        //TODO populating the result
        return result;
    }

    public static Set<Order> getOrders() {
        return orders;
    }

    public Date getDate() {
        return date;
    }

    public Group getGroup() {
        return group;
    }

    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
