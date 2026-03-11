package isep.eapli.demoorm.persistence;

import jakarta.persistence.*;
import java.util.List;
import java.util.Optional;

public abstract class JpaRepository<T, K> {

    private static EntityManagerFactory emf;

    protected EntityManager entityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("demoPU");
        }
        return emf.createEntityManager();
    }

    protected abstract Class<T> entityClass();

    public T save(T entity) {
        EntityManager em = entityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public Optional<T> findById(K id) {
        EntityManager em = entityManager();
        try {
            return Optional.ofNullable(em.find(entityClass(), id));
        } finally {
            em.close();
        }
    }

    public List<T> findAll() {
        EntityManager em = entityManager();
        try {
            return em.createQuery("SELECT e FROM " + entityClass().getSimpleName() + " e", entityClass())
                    .getResultList();
        } finally {
            em.close();
        }
    }

    protected List<T> findByAttribute(String attribute, Object value) {
        EntityManager em = entityManager();
        try {
            return em.createQuery("SELECT e FROM " + entityClass().getSimpleName() + " e WHERE e." + attribute + " = :value", entityClass())
                    .setParameter("value", value)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
