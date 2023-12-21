package code;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Coupon {


    static Set<Coupon> coupons;
    int DiscountValue;
    Date expiryDate;
    Product product;

    /**
     * Default constructor of a coupon
     * @param discountValue Percentage value of how much the price should be reduced by
     * @param expiryDate Date by which the coupon should be removed as it is no longer valid
     * @param product code.Product this coupon is for
     * @throws InvalidValueException Error thrown if value is not a valid percentage
     */
    public Coupon(int discountValue, Date expiryDate, Product product) throws InvalidValueException {
        if (discountValue>100 || discountValue<1)
            throw new InvalidValueException();
        DiscountValue = discountValue;
        this.expiryDate = expiryDate;
        this.product = product;
    }

    /**
     * View all coupons for products with only allergens accepted by the user
     * @param user code.User for which coupons are looked for
     * @return Set of coupons compliant with the specification
     */
    public static Set<Coupon> viewListOfCoupons(User user) {
        Set<Coupon> result = new HashSet<>();
        //TODO populating result
        return result;
    }

    /**
     * Method for adding a coupon
     * @param discountValue Percentage value of how much the price should be reduced by
     * @param expiryDate Date by which the coupon should be removed as it is no longer valid
     * @param product code.Product this coupon is for
     * @throws InvalidValueException Error thrown if value is not a valid percentage
     */
    public static void addCoupon(int discountValue, Date expiryDate, Product product) throws InvalidValueException {
        Coupon coupon = new Coupon(discountValue, expiryDate, product);
        coupons.add(coupon);
        product.getCoupons().add(coupon);
    }

}
