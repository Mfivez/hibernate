package jpaPark.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class CrudRepository<T, ID> implements ICrudRepository<T, ID> {
    private final EntityManagerFactory emf;
    private final Class<T> entityClass;

    public CrudRepository(Class<T> entityClass) {
        this.emf = Persistence.createEntityManagerFactory("jpapark");
        this.entityClass = entityClass;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<T> findAll() {
        EntityManager em = getEntityManager();
        List<T> results = em.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
        em.close();
        return results;
    }

    @Override
    public Optional<T> findById(ID id) {
        EntityManager em = getEntityManager();
        T entity = em.find(entityClass, id);
        em.close();
        return Optional.ofNullable(entity);
    }

    @Override
    public T insert(T t) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
        return t;
    }

    @Override
    public T update(T t) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        T updated = em.merge(t);
        em.getTransaction().commit();
        em.close();
        return updated;
    }

    @Override
    public T delete(ID id) {
        EntityManager em = getEntityManager();
        T entity = em.find(entityClass, id);
        if (entity != null) {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }
        em.close();
        return entity;
    }
}
