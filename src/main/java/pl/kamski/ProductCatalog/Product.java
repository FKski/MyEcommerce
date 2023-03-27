package pl.kamski.ProductCatalog;

import java.util.UUID;

public class Product {

    private final UUID uuid;
    private final String name;
    private final String description;

    public Product(UUID uuid, String name, String description){
        this.uuid = uuid;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return uuid.toString();
    }
}
