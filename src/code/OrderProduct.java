package code;

public class OrderProduct {
    private Product product;
    private Integer quantity;
    private Order order;

    /**
     * Default constructor of OrderProduct
     * @param product Product associated with OrderProduct
     * @param quantity quantity of the Product
     * @param order Order associated with OrderProduct
     */
    private OrderProduct(Product product, Integer quantity, Order order) {
        this.product = product;
        this.quantity = quantity;
        this.order = order;
    }

    /**
     * Default method used to initialize object of class OrderProduct. Automatically adds new associations to Product and Order classes
     * @param product Product associated with OrderProduct
     * @param quantity quantity of the Product
     * @param order Order associated with OrderProduct
     * @return Initialized OrderProduct object
     */
    public static OrderProduct createOrderProduct(Product product, Integer quantity, Order order) {
        OrderProduct newOrderProduct = new OrderProduct(product,quantity,order);
        product.addAssociatedOrderProduct(newOrderProduct);
        order.addToOrder(newOrderProduct);
        return newOrderProduct;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Order getOrder() {
        return order;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
