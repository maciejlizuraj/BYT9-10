import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RestaurantOwner extends VerifiedPerson {
    static HashMap<String, RestaurantOwner> restaurantOwners;
    Set<Restaurant> restaurants;

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
    public static void register(String email, String password) throws EmailAlreadyUsedException {
        RestaurantOwner restaurantOwner = new RestaurantOwner(email, password);
        if (restaurantOwners.containsKey(email)) {
            throw new EmailAlreadyUsedException();
        }
        restaurantOwners.put(email, restaurantOwner);
    }
}
