package pl.kamski.Sales;

import java.util.Optional;


public interface ProductDetailsProvider {
    Optional<ProductDetails> load(String productId);
}
