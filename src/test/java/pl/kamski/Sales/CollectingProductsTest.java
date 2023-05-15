package pl.kamski.Sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CollectingProductsTest {
    CartStorage cartStorage;
    ProductDetailsProvider productDetailsProvider;

    @BeforeEach
    void setup(){
        cartStorage = new CartStorage();
        productDetailsProvider = new ProductDetailsProvider();
    }

    @Test
    void itAllowsToAddProductToCart(){
        //Arrange
        Sales sales = thereIsSalesModule();
        String customerId = thereIsCustomer("Filip");
        String productId = thereIsProduct();
        //Act
        sales.addToCart(customerId, productId);
        //Assert
        assertCustomerCartContainsNProducts(customerId, 1);

    }

    private void assertCustomerCartContainsNProducts(String customerId, int productsCount) {
        Cart customerCart = cartStorage.load(customerId).get();
        assert customerCart.itemsCount() == productsCount;
    }

    private String thereIsProduct() {
        return null;
    }

    private String thereIsCustomer(String customer) {
        return null;
    }

    private Sales thereIsSalesModule() {
        return null;
    }
}
