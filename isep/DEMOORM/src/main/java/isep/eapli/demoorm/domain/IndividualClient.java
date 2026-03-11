package isep.eapli.demoorm.domain;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("INDIVIDUAL")
public class IndividualClient extends Client {

    @Column(name = "citizen_id")
    private String citizenId;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    protected IndividualClient() {}

    public IndividualClient(String name, String address, String phoneNumber, String email,
                            String remarks, String citizenId, String dateOfBirth) {
        super(name, address, phoneNumber, email, remarks);
        this.citizenId = citizenId;
        this.dateOfBirth = dateOfBirth;
    }

    public String getCitizenId() { return citizenId; }
    public String getDateOfBirth() { return dateOfBirth; }

    @Override
    protected String getClientType() { return "Individual"; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | CitizenID: %s | DOB: %s", citizenId, dateOfBirth);
    }
}
