package pl.kamski.Sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kamski.Sales.cart.Cart;
import pl.kamski.Sales.cart.CartStorage;
import pl.kamski.Sales.product.AlwaysMissingProductDetailsProvider;
import pl.kamski.Sales.product.ProductDetailsProvider;
import pl.kamski.payu.PayU;

import java.util.UUID;

public class CollectingProductsTest {

    private CartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;

    private PayU payU;

    @BeforeEach
    void setup() {
        cartStorage = new CartStorage();
        productDetailsProvider = new AlwaysMissingProductDetailsProvider();
    }

    @Test
    void itAllowsToCollectProductsToCart() {
        //Arrange
        Sales sales = thereIsSalesModule();
        String productId =  thereIsProduct();
        String customer = thereIsCustomer("filip");

        //Act
        sales.addToCart(customer, productId);

        //Assert
        assertThereIsNProductsInCustomersCart(customer, 1);
    }

    private void assertThereIsNProductsInCustomersCart(String customer, int productsCount) {
        Cart customerCart = cartStorage.load(customer).get();

        assert customerCart.itemsCount() == productsCount;
    }

    private String thereIsCustomer(String customerId) {
        return customerId;
    }

    private String thereIsProduct() {
        return UUID.randomUUID().toString();
    }

    private Sales thereIsSalesModule() {
        return new Sales(cartStorage, productDetailsProvider, payU);
    }
}