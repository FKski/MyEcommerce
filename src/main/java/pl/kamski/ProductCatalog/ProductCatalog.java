package pl.kamski.ProductCatalog;

import java.util.*;

public class ProductCatalog {

    private ArrayList<Product> products = new ArrayList<Product>();

    public List<Product> allProducts() {
        return products;
    }

    public String addProduct(String name, String description) {
        Product newOne = new Product(
                UUID.randomUUID(),
                name,
                description);
        products.add(newOne);
        return newOne.getId();
    }
}
