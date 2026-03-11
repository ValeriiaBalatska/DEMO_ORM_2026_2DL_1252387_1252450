package isep.eapli.demoorm.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "CHECK_PAYMENT")
public class CheckPayment extends Payment {

    @Column(name = "check_number")
    private String checkNumber;

    @Column(name = "bank_name")
    private String bankName;

    protected CheckPayment() {}

    public CheckPayment(double amount, String paymentDate, String checkNumber, String bankName) {
        super(amount, paymentDate);
        this.checkNumber = checkNumber;
        this.bankName = bankName;
    }

    public String getCheckNumber() { return checkNumber; }
    public String getBankName() { return bankName; }

    @Override
    protected String getPaymentType() { return "Check"; }
}
