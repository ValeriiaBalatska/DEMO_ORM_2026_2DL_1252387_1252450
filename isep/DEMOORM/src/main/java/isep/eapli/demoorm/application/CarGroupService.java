package isep.eapli.demoorm.application;

import isep.eapli.demoorm.domain.CarGroup;
import isep.eapli.demoorm.domain.CarClass;
import isep.eapli.demoorm.persistence.CarGroupRepository;
import isep.eapli.demoorm.persistence.CarGroupRepositoryJPAImpl;
import jakarta.persistence.*;
import java.util.List;
import java.util.Optional;

public class CarGroupService {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoPU");

    private final EntityManager em = emf.createEntityManager();
    private final CarGroupRepository repository = new CarGroupRepositoryJPAImpl(em);

    public CarGroup registerNewCarGroup(String name, int doors, double price, CarClass carClass) {
        CarGroup carGroup = new CarGroup(name, doors, price, carClass);
        return repository.save(carGroup);
    }

    public List<CarGroup> listAllCarGroups() {
        return repository.findAll();
    }

    public Optional<CarGroup> findCarGroupById(Long id) {
        return repository.findById(id);
    }

    public void close() {
        em.close();
    }
}