package app.v1.week4;


import java.util.ArrayList;
import java.util.List;



public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void deleteProduct(int index) {
        this.products.remove(index);
    }
}
