package isep.eapli.demoorm.persistence;

import isep.eapli.demoorm.domain.Car;
import isep.eapli.demoorm.domain.CarGroup;
import java.util.List;
import java.util.Optional;

public interface CarRepository {
    Car save(Car car);
    Optional<Car> findByLicensePlate(String licensePlate);
    List<Car> findAll();
    List<Car> findByCarGroup(CarGroup carGroup);
}
