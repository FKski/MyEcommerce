package pl.kamski.Sales.product;

import java.util.Optional;

public class AlwaysMissingProductDetailsProvider implements ProductDetailsProvider {
    @Override
    public Optional<ProductDetails> load(String productId) {
        return Optional.empty();
    }
}