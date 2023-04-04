package pl.kamski.ProductCatalog;

import org.junit.jupiter.api.Test;
import pl.kamski.creditcard.CantWithdrawOverCreditException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ProductCatalogTest {

//    @Test
//    void itExposeEmptyProductsList() {
//        //Arrange
//        ProductCatalog catalog = thereIsProductCatalog();
//        //Act
//        Map<String, Product> products = catalog.allProducts();
//        //Assert
//        AsssertEmptyList(products);
//    }

    @Test
    void publishedProductEmptyForNewCatalog() {
        //Arrange
        ProductCatalog catalog = thereIsProductCatalog();
        //Act
        Map<String, Product> products = catalog.allPublishedProducts();
        //Assert
        assert 0 == products.size();
    }

    private static void AsssertEmptyList(List<Product> products) {
        assert 0 == products.size();
    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }

    @Test
    void itAllowsToAddProduct() {
        //Arrange
        ProductCatalog catalog = thereIsProductCatalog();
        //Act
        String productId = catalog.addProduct("lego 8398", "nice one");
        //Assert

        Map<String, Product> products = catalog.allProducts();
        assert 1 == products.size();
    }

    @Test
    void itAllowsToLoadProductDetails() {
        ProductCatalog catalog = new ProductCatalog();
        String productId = catalog.addProduct("lego 8398","nice one");

        Product loaded = catalog.loadById(productId);
        assert productId.equals(loaded.getId());
    }

    @Test
    void itAllowsToChangePrice() {
        ProductCatalog catalog = thereIsProductCatalog();
        //Act
        String productId = catalog.addProduct("lego 8398", "nice one");

        catalog.changePrice(productId, BigDecimal.valueOf(20.20));
        Product loaded = catalog.loadById(productId);
        assertEquals(BigDecimal.valueOf(20.20), loaded.getPrice());
    }

    @Test
    void itAllowsToAssignImage() {
        ProductCatalog catalog = thereIsProductCatalog();
        //Act
        String productId = catalog.addProduct("lego 8398", "nice one");

        catalog.assignImage(productId, "nice/picture.jpg");
        Product loaded = catalog.loadById(productId);
        assertEquals("nice/picture.jpg", loaded.getImage());
    }

    @Test
    void productCantBePublishedWithoutPriceAndImage() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego 8398", "nice one");

        assertThrows(
                ProductCantBePublishedException.class,
                () -> catalog.publish(productId));
    }

    @Test
    void itAllowsToPublishProduct(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego 8398", "nice one");

        catalog.assignImage(productId, "nice.jpeg");
        catalog.changePrice(productId, BigDecimal.valueOf(10));

        catalog.publish(productId);

        Map<String, Product> products = catalog.allPublishedProducts();
        assertEquals(1, products.size());
    }
}
