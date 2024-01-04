package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Product {

    private String name;
    private String description;
    private double price;
    private Set<Allergen> allergens;
    private Restaurant restaurant;
    private Set<Coupon> coupons;
    private Set<OrderProduct> associatedOrderProducts;

    static Map<Allergen, Set<Product>> allergenToProducts = new HashMap<>();
    static Map<Restaurant, Set<Product>> restaurantToProducts = new HashMap<>();

    /**
     * Default constructor of a product
     * @param name
     * @param description
     * @param price Price of a single product
     * @param allergens Allergens present in the product
     * @param restaurant code.Restaurant in which the product is sold
     */
    public Product(String name, String description, double price, Set<Allergen> allergens, Restaurant restaurant) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.allergens = allergens;
        this.restaurant = restaurant;
        coupons = new HashSet<>();
        associatedOrderProducts = new HashSet<>();
    }

    /**
     * Allows viewing all products sold in a given restaurant which do not contain given allergens
     * @param restaurant code.Restaurant to be searched
     * @param allergens Blacklisted allergens
     * @return Set of products compliant to specification
     */
    static public Set<Product> viewListOfProducts(Restaurant restaurant, Set<Allergen> allergens) {
        HashSet<Product> results = new HashSet<>();
        //TODO filtering through the map
        return results;
    }

    /**
     * Method for adding a product. Takes care of adding it to required records.
     * @param product code.Product to be added
     */
    static public void addProduct(Product product) {
        for (Allergen allergen : product.getAllergens()) {
            Set<Product> set = allergenToProducts.computeIfAbsent(allergen, k -> new HashSet<>());
            set.add(product);
            allergenToProducts.put(allergen, set);
        }
        Restaurant restaurant = product.getRestaurant();
        Set<Product> set = restaurantToProducts.computeIfAbsent(restaurant, k -> new HashSet<>());
        set.add(product);
        restaurantToProducts.put(restaurant, set);
    }

    /**
     *
     * @return Set of allergens of this product
     */
    public Set<Allergen> viewSetOfAllergens() {
        return getAllergens();
    }

    /**
     * Removes a product from records.
     */
    public void removeProduct() {
        for (Allergen allergen : allergens) {
            allergenToProducts.get(allergen).remove(this);
        }
        restaurantToProducts.get(this.restaurant).remove(this);
    }

    /**
     * Adds new associated OrderProduct to this products list
     * @param orderProduct OrderProduct class object to be added
     */
    public void addAssociatedOrderProduct(OrderProduct orderProduct) {
        this.associatedOrderProducts.add(orderProduct);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Set<Allergen> getAllergens() {
        return allergens;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Set<Coupon> getCoupons() {
        return coupons;
    }

    public static Map<Allergen, Set<Product>> getAllergenToProducts() {
        return allergenToProducts;
    }

    public static Map<Restaurant, Set<Product>> getRestaurantToProducts() {
        return restaurantToProducts;
    }

    public Set<OrderProduct> getAssociatedOrderProducts() {
        return associatedOrderProducts;
    }


}
