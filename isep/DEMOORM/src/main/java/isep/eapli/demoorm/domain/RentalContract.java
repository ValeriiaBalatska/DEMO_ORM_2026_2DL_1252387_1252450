package isep.eapli.demoorm.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RENTAL_CONTRACT")
public class RentalContract {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_license_plate")
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "rental_contract_id")
    private List<AuthorizedDriver> authorizedDrivers = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    protected RentalContract() {}

    public RentalContract(String startDate, String endDate, Car car, Client client) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.car = car;
        this.client = client;
    }

    public Long getId() { return id; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public Car getCar() { return car; }
    public Client getClient() { return client; }
    public List<AuthorizedDriver> getAuthorizedDrivers() { return authorizedDrivers; }
    public Payment getPayment() { return payment; }

    public void addAuthorizedDriver(AuthorizedDriver driver) {
        authorizedDrivers.add(driver);
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[%d] %s to %s | Car: %s | Client: %s",
                id, startDate, endDate, car.getLicensePlate(), client.getName()));
        if (payment != null) {
            sb.append(" | ").append(payment);
        }
        if (!authorizedDrivers.isEmpty()) {
            sb.append("\n  Authorized Drivers:");
            authorizedDrivers.forEach(d -> sb.append("\n").append(d));
        }
        return sb.toString();
    }
}
