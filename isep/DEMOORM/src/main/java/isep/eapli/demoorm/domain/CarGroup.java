package isep.eapli.demoorm.domain;

import jakarta.persistence.*;

@Entity
public class CarGroup {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    protected CarGroup() {}
    public CarGroup(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    @Override public String toString() { return name + " (ID: " + id + ")"; }
}
