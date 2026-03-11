package isep.eapli.demoorm.application;

import isep.eapli.demoorm.domain.Car;
import isep.eapli.demoorm.domain.CarGroup;
import isep.eapli.demoorm.persistence.CarRepository;
import isep.eapli.demoorm.persistence.CarRepositoryJPAImpl;
import java.util.List;
import java.util.Optional;

public class CarService {

    private final CarRepository repository = new CarRepositoryJPAImpl();

    public Car registerNewCar(String licensePlate, int manufactureYear, int acquisitionYear,
                              String color, int engineDisplacement, CarGroup carGroup) {
        Car car = new Car(licensePlate, manufactureYear, acquisitionYear, color, engineDisplacement, carGroup);
        return repository.save(car);
    }

    public List<Car> listAllCars() {
        return repository.findAll();
    }

    public Optional<Car> findCarByLicensePlate(String licensePlate) {
        return repository.findByLicensePlate(licensePlate);
    }

    public List<Car> findCarsByCarGroup(CarGroup carGroup) {
        return repository.findByCarGroup(carGroup);
    }
}
