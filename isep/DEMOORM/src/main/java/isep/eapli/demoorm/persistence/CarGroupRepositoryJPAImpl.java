package isep.eapli.demoorm.persistence;

import isep.eapli.demoorm.domain.CarGroup;
import isep.eapli.demoorm.domain.CarClass;
import java.util.List;

public class CarGroupRepositoryJPAImpl extends JpaRepository<CarGroup, Long> implements CarGroupRepository {

    @Override
    protected Class<CarGroup> entityClass() {
        return CarGroup.class;
    }

    @Override
    public List<CarGroup> findByName(String name) {
        return findByAttribute("name", name);
    }

    @Override
    public List<CarGroup> findByCarClass(CarClass carClass) {
        return findByAttribute("carClass", carClass);
    }
}