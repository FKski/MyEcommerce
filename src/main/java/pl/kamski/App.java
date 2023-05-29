package pl.kamski;
import pl.kamski.creditcard.CreditCard;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CreditCard card = new CreditCard("1234-4567");
        card.assignCredit(BigDecimal.valueOf(1000));
        card.withdraw(BigDecimal.valueOf(100));
        card.withdraw(BigDecimal.valueOf(230));
        card.withdraw(BigDecimal.valueOf(159));

        System.out.println(card.getWithdrawReport());
    }


}