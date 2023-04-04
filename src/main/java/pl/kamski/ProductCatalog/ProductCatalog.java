package pl.kamski.ProductCatalog;

import java.math.BigDecimal;
import java.util.*;

public class ProductCatalog {

    private IProductStorage productStorage;

    public ProductCatalog(IProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    private Map<String, Product> products;

    //    private ArrayList<Product> products = new ArrayList<Product>();

    public ProductCatalog() {
        this.products = new HashMap<>();
    }

    public List<Product> allProducts() {
        return productStorage.allProducts();
    }


    public String addProduct(String name, String description) {
        Product newOne = new Product(
                UUID.randomUUID(),
                name,
                description);
        products.put(newOne.getId(), newOne);
        return newOne.getId();
    }

    public Map<String, Product> allPublishedProducts() {
        return products;
    }

    public Product loadById(String productId) {
        return products.get(productId);
    }

    public void changePrice(String productId, BigDecimal newPrice) {
        Product loaded = this.loadById(productId);
        loaded.changePrice(newPrice);
    }

    public void assignImage(String productId, String picture) {
        Product loaded = this.loadById(productId);
        loaded.setImage(picture);
    }

    public void publish(String productId) {
        Product loaded = this.loadById(productId);

        if(loaded.getPrice() == null){
            throw new ProductCantBePublishedException();
        }
        if(loaded.getImage() == null){
            throw new ProductCantBePublishedException();
        }

        products.put(loaded.getId(), loaded);

    }
}
