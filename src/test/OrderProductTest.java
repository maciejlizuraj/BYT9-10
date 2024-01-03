package test;

import code.*;
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
        p1 = new OrderProduct(carbonara, 2);
        p2 = new OrderProduct(margarita, 1);
    }

    @Test
    void constructorTest(){
        p3 = new OrderProduct(carbonara, 2);
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