package pl.kamski.Sales;

import pl.kamski.ProductCatalog.ProductCatalog;

import java.util.Optional;

public class ProductCatalogProductDetailsProvider implements ProductDetailsProvider{



    ProductCatalog productCatalog;
    public ProductCatalogProductDetailsProvider(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }
    @Override
    public Optional<ProductDetails> load(String productId) {
        pl.kamski.ProductCatalog.Product product = productCatalog.loadById(productId);
        if(product==null){
            return Optional.empty();
        }
        return Optional.of(new ProductDetails(
                product.getId(),
                product.getName(),
                product.getPrice()
        ));
    }
}
