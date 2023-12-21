package code;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Order {

    static Set<Order> orders = new HashSet<>();

    Date date;
    Group group;
    Map<Integer, Set<Product>> productsMap;
    double totalPrice;

    /**
     * Default constructor of an order
     * @param date Date when order was created
     * @param group code.Group which created the order
     * @param productsMap Maps quantities with sets of products ordered in those quantities
     */
    public Order(Date date, Group group, Map<Integer, Set<Product>> productsMap) {
        this.date = date;
        this.group = group;
        this.productsMap = productsMap;
        totalPrice = 0;
        for (Integer i : productsMap.keySet()) {
            for (Product product : productsMap.get(i)) {
                totalPrice += (double) i * product.getPrice();
            }
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


}
