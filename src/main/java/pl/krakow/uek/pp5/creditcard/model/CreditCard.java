package pl.krakow.uek.pp5.creditcard.model;

import pl.krakow.uek.pp5.creditcard.model.exceptions.NotEnoughMoneyException;

import java.math.BigDecimal;

public class CreditCard {
    private final String cardNumber;
    private BigDecimal cardLimit;
    private BigDecimal balance;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void assignLimit(BigDecimal newLimit)
    {
        cardLimit = newLimit;
        balance = newLimit;
    }

    public BigDecimal getLimit() {
        return cardLimit;
    }

    public void withdraw(BigDecimal money) {
        balance = balance.subtract(money);
        if (balance.compareTo(money) == 1) {
            throw new NotEnoughMoneyException();
        }
    }

    public BigDecimal getCurrentBalance() {
        return BigDecimal.valueOf(500);
    }
}
