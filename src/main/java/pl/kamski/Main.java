package pl.kamski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.kamski.ProductCatalog.HashMapProductStorage;
import pl.kamski.ProductCatalog.Product;
import pl.kamski.ProductCatalog.ProductCatalog;
import pl.kamski.Sales.*;
import pl.kamski.Sales.cart.CartStorage;
import pl.kamski.Sales.product.ProductDetails;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootApplication

public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);


    }

    @Bean
    ProductCatalog createMyProductCatalog(){

        ProductCatalog productCatalog =new ProductCatalog(new HashMapProductStorage());
        String product1 = productCatalog.addProduct("my ebook", "this is my newest e book");
        productCatalog.changePrice(product1, BigDecimal.valueOf(100));
        productCatalog.assignImage(product1, "/foo/niece/image.jpg");
        productCatalog.publishProduct(product1);
        String product2 = productCatalog.addProduct("my second ebook", "this is my second e book");
        productCatalog.changePrice(product2, BigDecimal.valueOf(85));
        productCatalog.assignImage(product2, "/foo/niece/image.jpg");
        productCatalog.publishProduct(product2);

        return productCatalog;
    }

    @Bean
    Sales createSales() {
        return new Sales(
                new CartStorage(),
                (String productId)->{
                    Product product = createMyProductCatalog().loadById(productId);
                    if (product==null){
                        return Optional.empty();
                    }
                    return Optional.of(new ProductDetails(
                            product.getId(),
                            product.getName(),
                            product.getPrice()
                    ));
                });
    }
}
