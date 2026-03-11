package isep.eapli.demoorm.persistence;

import isep.eapli.demoorm.domain.CarGroup;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CarGroupRepositoryJPAImpl implements CarGroupRepository {

    private final EntityManager em;

    public CarGroupRepositoryJPAImpl(EntityManager em) { this.em = em; }

    @Override
    public CarGroup save(CarGroup carGroup) {
        em.getTransaction().begin();
        em.persist(carGroup);
        em.getTransaction().commit();
        return carGroup;
    }

    @Override
    public Optional<CarGroup> findById(Long id) {
        return Optional.ofNullable(em.find(CarGroup.class, id));
    }

    @Override
    public List<CarGroup> findAll() {
        return em.createQuery("SELECT cg FROM CarGroup cg", CarGroup.class).getResultList();
    }
}