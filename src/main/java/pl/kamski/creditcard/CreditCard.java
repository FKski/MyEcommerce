package pl.kamski.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    private BigDecimal credit;
    private final String number;

    public CreditCard(String cardNumber) {
        this.number = cardNumber;
    }

    public void assignCredit(BigDecimal creditAmt) {
        if(isAlreadyAssigned()){
            throw new CantAssignCreditTwiceException();
        }
        if (isBelowThreshold(creditAmt)){
            throw new CreditLimitBelowThresholdException();
        }
        this.credit = creditAmt;
        this.balance = creditAmt;
    }

    public void withdraw(BigDecimal withdrawAmt){
        if (IsWithdrawGreaterThanCreditSumBalance(withdrawAmt)){
            throw new CantWithdrawOverCreditException();
        }
        balance = balance.subtract(withdrawAmt);
    }

    private boolean IsWithdrawGreaterThanCreditSumBalance(BigDecimal withdrawAmt) {
        BigDecimal sum = credit.add(balance);
        return (withdrawAmt.compareTo(sum) == 1);
    }

    private boolean isAlreadyAssigned() {
        return credit != null;
    }

    private static boolean isBelowThreshold(BigDecimal creditAmt) {
        return Integer.parseInt(creditAmt.toString()) < 100;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
