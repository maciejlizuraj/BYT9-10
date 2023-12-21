package test;

import code.EmailAlreadyUsedException;
import code.RestaurantOwner;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantOwnerTest{

    /**
     * test if restaurant owner is properly created and added to map
     */
    @org.junit.jupiter.api.Test
    void registerTest() throws EmailAlreadyUsedException {
        String email = "abc@gmail.com";
        String password = "qwerty";
        RestaurantOwner.register(email, password);

        assertTrue(RestaurantOwner.getRestaurantOwners().containsKey(email));
        assertEquals(password,
                RestaurantOwner.getRestaurantOwners().get(email).getPassword());

    }

    /**
     * test if EmailAlreadyUsedException is thrown correctly
     */
    @org.junit.jupiter.api.Test
     void registerSameEmail() throws EmailAlreadyUsedException {
        String email = "def@gmail.com";
        String password = "qwerty";
        RestaurantOwner.register(email, password);

        assertTrue(RestaurantOwner.getRestaurantOwners().containsKey(email));
        assertThrows(EmailAlreadyUsedException.class,
                () -> RestaurantOwner.register(email, "abc"));

    }
}