package isep.eapli.demoorm.persistence;

import isep.eapli.demoorm.domain.CarGroup;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CarGroupRepository {
    private final EntityManager em;

    public CarGroupRepository(EntityManager em) { this.em = em; }

    public CarGroup save(CarGroup carGroup) {
        em.getTransaction().begin();
        em.persist(carGroup);
        em.getTransaction().commit();
        return carGroup;
    }
}
