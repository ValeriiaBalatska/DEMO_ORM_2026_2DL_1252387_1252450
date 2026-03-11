package isep.eapli.demoorm.domain;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "client_type")
public abstract class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;
    private String remarks;

    protected Client() {}

    public Client(String name, String address, String phoneNumber, String email, String remarks) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.remarks = remarks;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public String getRemarks() { return remarks; }

    @Override
    public String toString() {
        return String.format("[%d] %s | %s | %s | %s", id, name, phoneNumber, email, getClientType());
    }

    protected abstract String getClientType();
}
