package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RestaurantOwner extends VerifiedPerson {
    private final static HashMap<String, RestaurantOwner> restaurantOwners = new HashMap<>();
    private final Set<Restaurant> restaurants;

    /**
     * Default constructor for a restaurant owner
     * @param email Email of the restaurant owner
     * @param password Password of the restaurant owner
     */
    public RestaurantOwner(String email, String password) {
        super(email, password);
        restaurants = new HashSet<>();
    }

    /**
     * Allows registering a restaurant owner
     * @param email Email of the restaurant owner
     * @param password Password of the restaurant owner
     * @throws EmailAlreadyUsedException Thrown if email is in use for a restaurant owner
     */
    public static RestaurantOwner register(String email, String password) throws EmailAlreadyUsedException {
        if (restaurantOwners.containsKey(email)) {
            throw new EmailAlreadyUsedException();
        }

        RestaurantOwner restaurantOwner = new RestaurantOwner(email, password);
        restaurantOwners.put(email, restaurantOwner);
        return restaurantOwner;
    }

    public static HashMap<String, RestaurantOwner> getRestaurantOwners() {
        return restaurantOwners;
    }
}
