package pl.kamski.Sales;


import pl.kamski.Sales.cart.Cart;
import pl.kamski.Sales.cart.CartStorage;
import pl.kamski.Sales.offering.Offer;
import pl.kamski.Sales.product.NoSuchProductException;
import pl.kamski.Sales.product.ProductDetails;
import pl.kamski.Sales.product.ProductDetailsProvider;
import pl.kamski.Sales.reservation.Reservation;
import pl.kamski.payu.*;

import java.util.Arrays;
import java.util.Optional;


public class Sales {
    private CartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;
    PayU payU;

    public Sales(CartStorage cartStorage, ProductDetailsProvider productDetailsProvider, PayU payU) {
        this.cartStorage= cartStorage;
        this.productDetailsProvider = productDetailsProvider;
        this.payU = payU;
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
    public PaymentData acceptOffer(String customerId, AcceptOffer request) {

        Offer offer = getCurrentOffer(customerId);

        OrderCreateRequest orderCreateRequest = new OrderCreateRequest();
        orderCreateRequest.setBuyer(
                new Buyer()
                        .setEmail(request.getEmail())
                        .setFirstName(request.getFname())
        );
        orderCreateRequest.setProducts(Arrays.asList(
                new Product()
                        .setName("Nice service")
                        .setUnitPrice(1)
                        .setUnitPrice(1000)
                        .setCurrencyCode("PLN")
        ));


        OrderCreateResponse response = payU.handle(orderCreateRequest);

        return new PaymentData(response.getRedirectUri(), response.getOrderId());

    }
}
