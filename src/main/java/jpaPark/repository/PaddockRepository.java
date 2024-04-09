package jpaPark.repository;

import jakarta.persistence.EntityManagerFactory;
import jpaPark.models.Paddock;

public class PaddockRepository extends AbstractRepository<Paddock, Long> {

    public PaddockRepository(EntityManagerFactory emf) {
        super(emf, Paddock.class);
    }
    @Override
    protected Long getId(Paddock paddock) {
        return paddock.getId();
    }
}
