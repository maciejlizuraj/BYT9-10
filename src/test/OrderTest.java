package test;

import code.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    RestaurantOwner owner;
    Restaurant restaurant;
    Product carbonara;
    Product margarita;
    User user;
    Group group;
    Set<OrderProduct> orderSet = new HashSet<>();
    Order order;

    @BeforeEach
    void setup() {
        owner = new RestaurantOwner("bartosz.kukula@gmail.com", "password123");
        restaurant = new Restaurant("Warsaw", "Puławska 145", "1902059684", owner);
        carbonara = new Product("Carbonara", "Spaghetti carbonara", 40, new HashSet<>(), restaurant);
        margarita = new Product("Margarita", "Pizza margarita", 30, new HashSet<>(), restaurant);
        user = new User("bartolomeo@gmail.com", "password123");
        group = new Group("group", user);
        orderSet.add(new OrderProduct(carbonara, 2));
        orderSet.add(new OrderProduct(margarita, 1));
        order = new Order(new Date(2024, Calendar.JANUARY, 3), group, orderSet);
    }

    @Test
    void constructorTest(){
        Order newOrder = new Order(new Date(2024, Calendar.JANUARY, 3), group, orderSet);
        assertEquals(newOrder, order);
    }
    @Test
    void sendTheOrder() {
        // TODO
    }

    @Test
    void checkOrderHistory() {
        // TODO
    }

    @Test
    void getOrders() {
        assertEquals(order,
                Order.getOrders().toArray()[0]);
    }

    @Test
    void getDate() {
        assertEquals(new Date(2024, Calendar.JANUARY, 3), order.getDate());
    }

    @Test
    void getGroup() {
        assertEquals(group, order.getGroup());
    }

    @Test
    void getOrderProducts() {
        assertEquals(orderSet, order.getOrderProducts());
    }

    @Test
    void getTotalPrice() {
        assertEquals(110.0,order.getTotalPrice(),1);
    }
}