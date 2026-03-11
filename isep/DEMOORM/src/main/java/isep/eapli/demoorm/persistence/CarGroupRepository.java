package isep.eapli.demoorm.persistence;

import isep.eapli.demoorm.domain.CarGroup;
import java.util.List;
import java.util.Optional;

public interface CarGroupRepository {
    CarGroup save(CarGroup carGroup);
    Optional<CarGroup> findById(Long id);
    List<CarGroup> findAll();
}