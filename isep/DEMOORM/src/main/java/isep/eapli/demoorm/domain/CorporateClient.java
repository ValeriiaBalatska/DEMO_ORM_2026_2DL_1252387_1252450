package isep.eapli.demoorm.domain;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CORPORATE")
public class CorporateClient extends Client {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "tax_id")
    private String taxId;

    protected CorporateClient() {}

    public CorporateClient(String name, String address, String phoneNumber, String email,
                           String remarks, String companyName, String taxId) {
        super(name, address, phoneNumber, email, remarks);
        this.companyName = companyName;
        this.taxId = taxId;
    }

    public String getCompanyName() { return companyName; }
    public String getTaxId() { return taxId; }

    @Override
    protected String getClientType() { return "Corporate"; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Company: %s | TaxID: %s", companyName, taxId);
    }
}
