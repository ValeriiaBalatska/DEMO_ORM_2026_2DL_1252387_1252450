package isep.eapli.demoorm.domain;

import jakarta.persistence.*;

@Entity
public class CarGroup {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "num_doors")
    private int numberOfDoors;

    @Column(name = "price_per_day")
    private double pricePerDay;

    @Enumerated(EnumType.STRING)
    private CarClass carClass;

    protected CarGroup() {}

    public CarGroup(String name, int numberOfDoors, double pricePerDay, CarClass carClass) {
        this.name = name;
        this.numberOfDoors = numberOfDoors;
        this.pricePerDay = pricePerDay;
        this.carClass = carClass;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getNumberOfDoors() { return numberOfDoors; }
    public double getPricePerDay() { return pricePerDay; }
    public CarClass getCarClass() { return carClass; }

    @Override
    public String toString() {
        return String.format("[%d] %s | %d doors | %.2f/day | %s", id, name, numberOfDoors, pricePerDay, carClass);
    }
}