package pl.kamski.ProductCatalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private final UUID uuid;
    private final String name;
    private final String description;
    private BigDecimal price;
    private String image;
    private boolean online;

    public Product(UUID uuid, String name, String description){
        this.uuid = uuid;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return uuid.toString();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void changePrice(BigDecimal newPrice) {
        this.price = newPrice;
    }

    public void setImage(String picture) {
        this.image = picture;
    }

    public String getImage() {
        return image;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean getOnline(){
        return online;
    }
}
