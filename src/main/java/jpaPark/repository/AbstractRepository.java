package jpaPark.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jpaPark.models.WithId;

import java.util.List;
import java.util.Optional;

public abstract class AbstractRepository<T extends WithId<ID>,ID> implements ICrudRepository<T,ID> {

    private final EntityManager em;
    private final Class<T> entityClass;

    public AbstractRepository(EntityManagerFactory emf, Class<T> entityClass){
        this.em = emf.createEntityManager();
        this.entityClass = entityClass;
    }


    @Override
    public List<T> findAll() {
        List<T> entities = em.createQuery("SELECT e FROM %s e".formatted(entityClass.getSimpleName()), entityClass)
                .getResultList();
        em.clear();
        return entities;
    }

    @Override
    public Optional<T> findById(ID id) {
        T entity = em.find(entityClass, id);
        em.clear();
        return Optional.ofNullable(entity);
    }

    @Override
    public T insert(T t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        return t;
    }

    @Override
    public T update(T t) {
        T toUpdate = em.find(entityClass, t.getId());
        if( toUpdate == null )
            throw new RuntimeException("Not found");

        em.getTransaction().begin();
        t = em.merge(t);
        em.getTransaction().commit();
        return t;
    }

    @Override
    public T delete(ID id) {
        T toDelete = em.find(entityClass, id);
        if( toDelete == null )
            throw new RuntimeException("Not found");

        em.getTransaction().begin();
        em.remove(toDelete);
        em.getTransaction().commit();
        return toDelete;
    }

    protected abstract ID getId(T entity);
}
