package pl.kamski.Sales;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kamski.Sales.offering.Offer;

@RestController
public class SalesController {
    Sales sales;


    public SalesController(Sales sales){
        this.sales = sales;
    }
    @PostMapping("/api/accept-offer")
    public void acceptOffer() {
        sales.acceptOffer(getCurrentCustomer(), getCurrentAcceptOffer());
    }

    @GetMapping("/api/get-current-offer")
    public Offer getCurrentOffer(){
        return sales.getCurrentOffer(getCurrentCustomer());
    }

    @PostMapping("/api/add-to-cart/{productId}")
    public void addToCart(@PathVariable String productId){
    sales.addToCart(getCurrentCustomer(),productId);
    }

    private String getCurrentCustomer(){
        return "Filip";
    }
    private  AcceptOffer getCurrentAcceptOffer(){
        return new AcceptOffer("filip@example.com","filip");
    }


}
