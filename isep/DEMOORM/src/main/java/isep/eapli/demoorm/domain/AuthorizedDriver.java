package isep.eapli.demoorm.domain;

import jakarta.persistence.*;

@Entity
public class AuthorizedDriver {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @Column(name = "license_number")
    private String licenseNumber;

    @Column(name = "license_expiry_date")
    private String licenseExpiryDate;

    protected AuthorizedDriver() {}

    public AuthorizedDriver(String name, String address, String licenseNumber, String licenseExpiryDate) {
        this.name = name;
        this.address = address;
        this.licenseNumber = licenseNumber;
        this.licenseExpiryDate = licenseExpiryDate;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getLicenseNumber() { return licenseNumber; }
    public String getLicenseExpiryDate() { return licenseExpiryDate; }

    @Override
    public String toString() {
        return String.format("  Driver: %s | License: %s (expires: %s)", name, licenseNumber, licenseExpiryDate);
    }
}
