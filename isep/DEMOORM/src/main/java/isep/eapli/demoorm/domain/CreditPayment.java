package isep.eapli.demoorm.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "CREDIT_PAYMENT")
public class CreditPayment extends Payment {

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "card_expiry_date")
    private String cardExpiryDate;

    protected CreditPayment() {}

    public CreditPayment(double amount, String paymentDate, String cardNumber,
                         String cardHolderName, String cardExpiryDate) {
        super(amount, paymentDate);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getCardNumber() { return cardNumber; }
    public String getCardHolderName() { return cardHolderName; }
    public String getCardExpiryDate() { return cardExpiryDate; }

    @Override
    protected String getPaymentType() { return "Credit Card"; }
}
