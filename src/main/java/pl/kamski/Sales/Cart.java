package pl.kamski.Sales;

public class Cart {
    int itemsCount;

    public static Cart empty() {
        return null;
    }

    public void add(Product product) {
        itemsCount++;
    }

    public int itemsCount() {
        return itemsCount;
    }
}
