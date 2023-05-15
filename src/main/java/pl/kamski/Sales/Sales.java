package pl.kamski.Sales;


import java.util.Optional;

public class Sales {
    private CartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;

    public Sales(CartStorage cartStorage, ProductDetailsProvider productDetailsProvider) {
        this.cartStorage= cartStorage;
        this.productDetailsProvider = productDetailsProvider;
    }

    public void addToCart(String customerId, String productId) {
        Cart cart = loadForCustomer(customerId)
                .orElse(Cart.empty());
        Product product = loadDetailsForProduct(productId);
        cart.add(product);
        cartStorage.save(customerId, cart);
    }

    private Product loadDetailsForProduct(String productId) {
        return productDetailsProvider.load(productId)
                .orElseThrow(()-> new NoSuchProductException()  );
    }

    private Optional<Cart> loadForCustomer(String customerId) {
        return cartStorage.load(customerId);
    }

    public Offer getCurrentOffer(String currentCustomer) {
        return new Offer();
    }
}
