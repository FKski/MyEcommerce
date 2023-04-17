package pl.kamski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.kamski.ProductCatalog.HashMapProductStorage;
import pl.kamski.ProductCatalog.ProductCatalog;
import pl.kamski.ProductCatalog.ProductStorage;

@SpringBootApplication

public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);


    }

    @Bean
    ProductCatalog createMyProductCatalog(){
        return new ProductCatalog(new HashMapProductStorage());
    }
}
