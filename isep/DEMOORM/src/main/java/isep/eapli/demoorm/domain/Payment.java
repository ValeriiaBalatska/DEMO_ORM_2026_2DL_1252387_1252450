package isep.eapli.demoorm.domain;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Payment {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double amount;

    @Column(name = "payment_date")
    private String paymentDate;

    protected Payment() {}

    public Payment(double amount, String paymentDate) {
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Long getId() { return id; }
    public double getAmount() { return amount; }
    public String getPaymentDate() { return paymentDate; }

    protected abstract String getPaymentType();

    @Override
    public String toString() {
        return String.format("Payment: %.2f on %s (%s)", amount, paymentDate, getPaymentType());
    }
}
