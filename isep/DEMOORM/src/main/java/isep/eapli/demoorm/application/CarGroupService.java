package isep.eapli.demoorm.application;

import isep.eapli.demoorm.domain.CarGroup;
import isep.eapli.demoorm.persistence.CarGroupRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CarGroupService {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoPU");
    private final EntityManager em = emf.createEntityManager();
    private final CarGroupRepository repository = new CarGroupRepository(em);

    public CarGroup registerNewCarGroup(String name, String description) {
        CarGroup carGroup = new CarGroup(name, description);
        return repository.save(carGroup);
    }

    public void close() {
        em.close();
        emf.close();
    }
}
