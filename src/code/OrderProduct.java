package code;

public class OrderProduct {
    private Order order;
    private Product product;
    private Integer quantity;

    public OrderProduct(Order order, Product product, Integer quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
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
