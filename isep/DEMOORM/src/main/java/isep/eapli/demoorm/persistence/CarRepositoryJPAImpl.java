package isep.eapli.demoorm.persistence;

import isep.eapli.demoorm.domain.Car;
import isep.eapli.demoorm.domain.CarGroup;
import java.util.List;
import java.util.Optional;

public class CarRepositoryJPAImpl extends JpaRepository<Car, String> implements CarRepository {

    @Override
    protected Class<Car> entityClass() {
        return Car.class;
    }

    @Override
    public Optional<Car> findByLicensePlate(String licensePlate) {
        return findById(licensePlate);
    }

    @Override
    public List<Car> findByCarGroup(CarGroup carGroup) {
        return findByAttribute("carGroup", carGroup);
    }
}
