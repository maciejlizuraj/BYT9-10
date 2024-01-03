package test;

import code.Restaurant;
import code.RestaurantOwner;
import code.AlreadyAnOwnerException;
import code.NotAnOwnerException;
import code.OnlyOwnerException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    private Restaurant restaurant;
    private RestaurantOwner owner;

    @BeforeEach
    void setUp() {
        owner = new RestaurantOwner("Maza Fazer", "mazer@fazer.com");
        restaurant = new Restaurant("Gomel, Belarus", "Sosiska Street 44/27", "123456789", owner);
    }

    @Test
    void constructorTest(){
        assertEquals("Gomel, Belarus", restaurant.getLocation());
        assertEquals("Sosiska Street 44/27", restaurant.getAddress());
        assertEquals("123456789", restaurant.getNIP());
        assertTrue(restaurant.getOwners().contains(owner));
        assertTrue(Restaurant.getRestaurants().contains(restaurant));
    }

    @Test
    void addAnOwner() {
        RestaurantOwner newOwner = new RestaurantOwner("Alice Giger", "giga@example.com");
        assertDoesNotThrow(() -> restaurant.addAnOwner(newOwner));
        assertTrue(restaurant.getOwners().contains(newOwner));
        assertThrows(AlreadyAnOwnerException.class, () -> restaurant.addAnOwner(owner));
    }

    @Test
    void removeAnOwner() throws AlreadyAnOwnerException {
        RestaurantOwner newOwner = new RestaurantOwner("Alice Giger", "giga@example.com");
        restaurant.addAnOwner(newOwner);
        assertDoesNotThrow(() -> restaurant.removeAnOwner(owner));
        assertFalse(restaurant.getOwners().contains(owner));
        assertThrows(NotAnOwnerException.class, () -> restaurant.removeAnOwner(owner));
        assertThrows(OnlyOwnerException.class, () -> restaurant.removeAnOwner(newOwner));
    }

    @Test
    void getRestaurants() {
        assertTrue(Restaurant.getRestaurants().contains(restaurant));
    }

    @Test
    void getLocation() {
        assertEquals("Gomel, Belarus", restaurant.getLocation());
    }

    @Test
    void getAddress() {
        assertEquals("Sosiska Street 44/27", restaurant.getAddress());
    }

    @Test
    void getNIP() {
        assertEquals("123456789", restaurant.getNIP());
    }

    @Test
    void getOwners() {
        assertTrue(restaurant.getOwners().contains(owner));
        assertEquals(1, restaurant.getOwners().size());
    }
}
