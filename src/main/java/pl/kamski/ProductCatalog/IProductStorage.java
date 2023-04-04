package pl.kamski.ProductCatalog;

import java.util.List;

public interface IProductStorage {
    List<Product> allProducts();

    void add(Product newProduct);

    Product loadById(String productId);

    List<Product> allPublishedProducts();
}
