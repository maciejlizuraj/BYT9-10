package test;

import code.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class OrderProductTest {

    RestaurantOwner owner;
    Restaurant restaurant;
    Product carbonara;
    Product margarita;
    User user;
    Group group;
    Order order;
    OrderProduct p1;
    OrderProduct p2;
    @BeforeEach
    void setup() {
        owner = new RestaurantOwner("bartosz.kukula@gmail.com", "password123");
        restaurant = new Restaurant("Warsaw", "Puławska 145", "1902059684", owner);
        carbonara = new Product("Carbonara", "Spaghetti carbonara", 40, new HashSet<>(), restaurant);
        margarita = new Product("Margarita", "Pizza margarita", 30, new HashSet<>(), restaurant);
        user = new User("bartolomeo@gmail.com", "password123");
        group = new Group("group", user);
        order = new Order(new Date(2024, Calendar.JANUARY, 3), group);
        p1 = OrderProduct.createOrderProduct(carbonara,2,order);
        p2 = OrderProduct.createOrderProduct(margarita,1,order);
    }

    @Test
    void constructorTest(){
        p2 = OrderProduct.createOrderProduct(carbonara, 2, order);
    }
    @Test
    void getQuantity() {
        assertEquals(1, p2.getQuantity());
    }

    @Test
    void getProduct() {
        assertEquals(carbonara, p1.getProduct());
    }

    @Test
    void setQuantity() {
        p2.setQuantity(2);
        assertEquals(2,p2.getQuantity());
    }
}