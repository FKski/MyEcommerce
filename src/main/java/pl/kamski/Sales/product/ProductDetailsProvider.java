package pl.kamski.Sales.product;

import java.util.Optional;


public interface ProductDetailsProvider {
    Optional<ProductDetails> load(String productId);
}
