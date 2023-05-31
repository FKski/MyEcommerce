package pl.kamski.Sales;


import pl.kamski.Sales.cart.Cart;
import pl.kamski.Sales.cart.CartStorage;
import pl.kamski.Sales.offering.Offer;
import pl.kamski.Sales.product.NoSuchProductException;
import pl.kamski.Sales.product.ProductDetails;
import pl.kamski.Sales.product.ProductDetailsProvider;
import pl.kamski.Sales.reservation.Reservation;

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
        ProductDetails product = loadDetailsForProduct(productId);

        cart.add(product);
        cartStorage.save(customerId, cart);
    }

    private ProductDetails loadDetailsForProduct(String productId) {
        return productDetailsProvider.load(productId)
                .orElseThrow(()-> new NoSuchProductException()  );
    }
    private Optional<ProductDetails> getProductDetails(String productId) {
        return productDetailsProvider.load(productId);
    }
    private Optional<Cart> loadForCustomer(String customerId) {
        return cartStorage.load(customerId);
    }

    public Offer getCurrentOffer(String currentCustomer) {
        return new Offer();
    }
    public PaymentData acceptOffer(String customerId) {

        Offer offer = getCurrentOffer(customerId);

//        Reservation reservation = Reservation.from(offer);
//
//        reservationStorage.save(reservation);


        return null;
    }
}
