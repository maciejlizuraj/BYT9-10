package code;

public class OrderProduct {
    private Product product;
    private Integer quantity;

    public OrderProduct(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
