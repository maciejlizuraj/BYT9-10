package test;

import code.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;
    private Set<Allergen> allergens;
    private Restaurant restaurant;
    private RestaurantOwner owner;

    @BeforeEach
    void setUp() {
        allergens = new HashSet<>();
        allergens.add(Allergen.PEANUTS);
        owner = new RestaurantOwner("Carefour Enjoyer", "carefour@example.pl");
        restaurant = new Restaurant("Gomel, Belarus", "Sosiska Street 44/27", "123456789", owner);
        product = new Product("Pizza Diablo", "Delicious Hell yeah cheese pizza", 9.99, allergens, restaurant);
    }

    @Test
    void constructorTest(){
        assertEquals("Pizza Diablo", product.getName());
        assertEquals("Delicious Hell yeah cheese pizza", product.getDescription());
        assertEquals(9.99, product.getPrice());
        assertEquals(allergens, product.getAllergens());
        assertEquals(restaurant, product.getRestaurant());
    }


    @Test
    void addProduct() {
        Product.addProduct(product);
        assertTrue(Product.getAllergenToProducts().containsKey(Allergen.PEANUTS));
        assertTrue(Product.getRestaurantToProducts().containsKey(restaurant));
    }

    @Test
    void viewSetOfAllergens() {
        assertEquals(allergens, product.viewSetOfAllergens());
    }

    @Test
    void removeProduct() {
        Product.addProduct(product);
        product.removeProduct();
        assertFalse(Product.getAllergenToProducts().get(Allergen.PEANUTS).contains(product));
        assertFalse(Product.getRestaurantToProducts().get(restaurant).contains(product));
    }

    @Test
    void getName() {
        assertEquals("Pizza Diablo", product.getName());
    }

    @Test
    void getDescription() {
        assertEquals("Delicious Hell yeah cheese pizza", product.getDescription());
    }

    @Test
    void getPrice() {
        assertEquals(9.99, product.getPrice());
    }

    @Test
    void getAllergens() {
        assertEquals(allergens, product.getAllergens());
    }

    @Test
    void getRestaurant() {
        assertEquals(restaurant, product.getRestaurant());
        assertEquals("Gomel, Belarus", product.getRestaurant().getLocation());
        assertEquals("Sosiska Street 44/27", product.getRestaurant().getAddress());
        assertEquals("123456789", product.getRestaurant().getNIP());
        assertTrue(product.getRestaurant().getOwners().contains(owner));
    }

    @Test
    void getCoupons() {
        Set<Coupon> coupons = product.getCoupons();
        assertNotNull(coupons);
        assertTrue(coupons.isEmpty());
    }

    @Test
    void getAllergenToProducts() {
        Product.addProduct(product);
        assertEquals(1, Product.getAllergenToProducts().get(Allergen.PEANUTS).size());
    }

    @Test
    void getRestaurantToProducts() {
        Product.addProduct(product);
        assertEquals(1, Product.getRestaurantToProducts().get(restaurant).size());
    }
}