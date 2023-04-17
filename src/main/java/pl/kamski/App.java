package pl.kamski;
import pl.kamski.creditcard.CreditCard;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jakub", "Michal",
                "Agnieszka", "Ola", "Kasia");
        Greeter greeter = new Greeter();
//        greeter.greet("Jakub"); // -> Hello Jakub

//        List<String> ladies = new ArrayList<String>();
//        for (String name : names) {
//            if (name.endsWith("a")) {
//                ladies.add(name);
//            }
//        }
//        for (String ladyName: ladies) {
//            greeter.greet(ladyName);
//        }

        names.stream()
                .filter(name -> name.endsWith("a")) // python way lambda name: name[-1] == "a"
                .forEach(greeter::greet);


        CreditCard card = new CreditCard("1234-4567");
        card.assignCredit(BigDecimal.valueOf(1000));
        card.withdraw(BigDecimal.valueOf(100));
        card.withdraw(BigDecimal.valueOf(230));
        card.withdraw(BigDecimal.valueOf(159));

        System.out.println(card.getWithdrawReport());
    }


}