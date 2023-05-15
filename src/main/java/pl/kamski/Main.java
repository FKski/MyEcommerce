package pl.kamski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationAotProcessor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.kamski.ProductCatalog.HashMapProductStorage;
import pl.kamski.ProductCatalog.ProductCatalog;
import pl.kamski.ProductCatalog.ProductStorage;
import pl.kamski.Sales.CartStorage;
import pl.kamski.Sales.ProductDetailsProvider;
import pl.kamski.Sales.Sales;

import java.math.BigDecimal;

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
        return new Sales(new CartStorage(), new ProductDetailsProvider());
    }
}
