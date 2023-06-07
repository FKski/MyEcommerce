package pl.kamski.payu;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PayUTest {

    @Test
    void creatingNewPaymentOrder(){
        OrderCreateRequest request = thereIsExampleOrderCreaterequest();
        PayU payu = thereIsPayU();

        OrderCreateResponse response = payu.handle(request);
        assertNotNull(response.getRedirectUri());
        assertNotNull(response.getOrderId());

    }

    private PayU thereIsPayU() {
        return new PayU(new RestTemplate());
    }

    private OrderCreateRequest thereIsExampleOrderCreaterequest() {
        OrderCreateRequest request = new OrderCreateRequest();
        request
                .setNotifyUrl("https://your.eshop.com/notify")
                .setCustomerIp("127.0.0.1")
                .setMerchantPosId("300746")
                .setDescription("Nice service")
                .setCurrencyCode("PLN")
                .setTotalAmount(21000)
                .setBuyer(new Buyer()
                        .setEmail("fifi.k@ex.com")
                        .setFirstName("Filip")
                        .setLastName("Kski")
                        .setPhone("123456789")
                        .setLanguage("pl")
                )
                .setProducts(Arrays.asList(
                        new Product()
                                .setName("Nice service")
                                .setUnitPrice(21000)
                                .setQuantity(1)
                ));
        return request;
    }
}
