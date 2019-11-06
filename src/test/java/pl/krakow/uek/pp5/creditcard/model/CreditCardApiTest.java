package pl.krakow.uek.pp5.creditcard.model;

import org.junit.Test;

public class CreditCardApiTest {

    public static final String CREDIT_CARD_NUMBER = "1234-5678";
    public static final BigDecimal CC_LIMIT = BigDecimal.valueOf(1000);

    @Test
    public void iAmAbleToWithdrawFromCard() {
        thereIsCCPermanentStorage();
        thereIsCreditCard(CREDIT_CARD_NUMBER);
        thereIsCCApi();

        api.withdraw(CREDIT_CARD_NUMBER, BigDecimal.valueOf(200));

        ccWirthNumberBalanceEquals(CREDIT_CARD_NUMBER, BigDecimal.valueOf(800))
    }

    private void thereIsCCPermanentStorage() {
        this.storage = new InMemoryCreditCardStorage();
    }

    private void thereIsCreditCard(String creditCardNumber) {
        CreditCard cc = new CreditCard(creditCardNumber);
        cc.assignLimit(CC_LIMIT);
    }

}
