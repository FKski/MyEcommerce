package pl.kamski.Sales.cart;

import pl.kamski.Sales.product.ProductDetails;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<String> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public static Cart empty() {
        return new Cart();
    }

    public void add(ProductDetails product) {
        products.add(product.getId());
    }

    public int itemsCount() {
        return 0;
    }
}