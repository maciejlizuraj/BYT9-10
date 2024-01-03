package code;

import java.util.HashSet;
import java.util.Set;

public class Restaurant {

    static Set<Restaurant> restaurants = new HashSet<>();
    String location;
    String address;
    String NIP;
    Set<RestaurantOwner> owners;

    /**
     * Default constructor for a restaurant
     * @param location Country and city in which restaurant is located
     * @param address Street and number of restaurant
     * @param NIP
     * @param owner Owner of the restaurant
     */
    public Restaurant(String location, String address, String NIP, RestaurantOwner owner) {
        //TODO any constraints?
        this.location = location;
        this.address = address;
        this.NIP = NIP;
        owners = new HashSet<>();
        owners.add(owner);
        restaurants.add(this);
    }

    /**
     * Allows adding another owner to a restaurant
     * @param owner Owner to be added
     * @throws AlreadyAnOwnerException Thrown if owner to be added is already present as an owner
     */
    public void addAnOwner(RestaurantOwner owner) throws AlreadyAnOwnerException { //Added to the diagram by AV
        if (owners.contains(owner))
            throw new AlreadyAnOwnerException();
        owners.add(owner);
    }

    /**
     * Allows removing an owner from a restaurant
     * @param owner Owner to be removed
     * @throws NotAnOwnerException Thrown if owner to be deleted is not present as an owner
     * @throws OnlyOwnerException Thrown if removing the owner would mean making the restaurant owner-less
     */
    public void removeAnOwner(RestaurantOwner owner) throws NotAnOwnerException, OnlyOwnerException { //Added to the diagram by AV
        if (!owners.contains(owner))
            throw new NotAnOwnerException();
        if(owners.size()==1)
            throw new OnlyOwnerException();
        owners.remove(owner);
    }

    public static Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public String getLocation() {
        return location;
    }

    public String getAddress() {
        return address;
    }

    public String getNIP() {
        return NIP;
    }

    public Set<RestaurantOwner> getOwners() {
        return owners;
    }
}
