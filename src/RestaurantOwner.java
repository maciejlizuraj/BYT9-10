import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RestaurantOwner extends VerifiedPerson {
    static HashMap<String, RestaurantOwner> restaurantOwners;
    Set<Restaurant> restaurants;

    public RestaurantOwner(String email, String password) throws EmailAlreadyUsedException {
        super(email, password);
        if (restaurantOwners.containsKey(email)) {
            throw new EmailAlreadyUsedException();
        }
        restaurantOwners.put(email, this);
        restaurants = new HashSet<>();
    }
}
