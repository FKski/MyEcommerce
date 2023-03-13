package pl.kamski.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    private final String number;

    public CreditCard(String cardNumber) {
        this.number = cardNumber;
    }

    public void assignCredit(BigDecimal creditAmt) {
        if (isBelowThreshold(creditAmt)){
            throw new CreditLimitBelowThresholdException();
        }
        this.balance = creditAmt;
    }

    private static boolean isBelowThreshold(BigDecimal creditAmt) {
        return Integer.parseInt(creditAmt.toString()) < 100;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
