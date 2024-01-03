package test;

import code.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CouponTest {

    RestaurantOwner owner;
    Restaurant italianRestaurant;
    Product carbonara;
    Coupon discount;

    @BeforeEach
    void setup() throws InvalidValueException {
        owner = new RestaurantOwner("bartosz.kukula@gmail.com", "password123");
        italianRestaurant = new Restaurant("Warsaw", "Puławska 145", "1902059684", owner);
        carbonara = new Product("Carbonara", "Spaghetti carbonara", 40, new HashSet<>(), italianRestaurant);
        Coupon.addCoupon(20, new Date(2024, Calendar.JULY,20), carbonara);
        discount = new Coupon(20, new Date(2024, Calendar.JULY,20), carbonara);
    }

    @Test
    void constructorTest() throws InvalidValueException {
        Coupon newDiscount = new Coupon(20,new Date(2024, Calendar.JULY,20), carbonara);
        assertThrows(InvalidValueException.class, () -> new Coupon(200,new Date(2024, Calendar.JULY,20), carbonara));

    }
    @Test
    void viewListOfCoupons() {
        // TODO
    }

    @Test
    void addCoupon() {
        // TODO
    }

    @Test
    void getDiscountValue() {
        assertEquals(20, discount.getDiscountValue());
    }

    @Test
    void getExpiryDate() {
        assertEquals(new Date(2024,Calendar.JULY, 20), discount.getExpiryDate());
    }

    @Test
    void getProduct() {
        assertEquals(carbonara, discount.getProduct());
    }

    @Test
    void getCoupons() {
        assertEquals(false,Coupon.getCoupons().isEmpty());
    }
}