package pl.kamski.Sales;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesController {
    Sales sales;


    public SalesController(Sales sales){
        this.sales = sales;
    }

    @GetMapping("/api/offer")
    public Offer getCurrentOffer(){
        return sales.getCurrentOffer(getCurrentCustomer());
    }

    @PostMapping("/api/add-to-cart/{productId}")
    public void addToCart(@PathVariable String produdctId){

    }

    private String getCurrentCustomer(){
        return "Filip";
    }

}
