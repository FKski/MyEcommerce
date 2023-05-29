package pl.kamski.Sales;

import java.util.ArrayList;
public class Cart {
    int itemsCount;
    ArrayList<String> products = new ArrayList<>();
    public static Cart empty() {
        return null;
    }

    public void add(ProductDetails product) {
        products.add(product.getId());
        itemsCount++;
    }

    public int itemsCount() {
        return itemsCount;
    }
}
