package isep.eapli.demoorm.domain;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    private String licensePlate;

    private int manufactureYear;
    private int acquisitionYear;
    private String color;
    private int engineDisplacement;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_group_id")
    private CarGroup carGroup;

    protected Car() {}

    public Car(String licensePlate, int manufactureYear, int acquisitionYear,
               String color, int engineDisplacement, CarGroup carGroup) {
        this.licensePlate = licensePlate;
        this.manufactureYear = manufactureYear;
        this.acquisitionYear = acquisitionYear;
        this.color = color;
        this.engineDisplacement = engineDisplacement;
        this.carGroup = carGroup;
    }

    public String getLicensePlate() { return licensePlate; }
    public int getManufactureYear() { return manufactureYear; }
    public CarGroup getCarGroup() { return carGroup; }

    @Override
    public String toString() {
        return String.format("[%s] %d | %s | %dcc | group: %s",
                licensePlate, manufactureYear, color, engineDisplacement, carGroup.getName());
    }
}