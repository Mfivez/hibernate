package jpaPark.repository;

import jakarta.persistence.EntityManagerFactory;
import jpaPark.models.MultiplePaddock;

public class EnclosMultipleRepository extends AbstractRepository<MultiplePaddock, Long> {

    public EnclosMultipleRepository(EntityManagerFactory emf) {
        super(emf, MultiplePaddock.class);
    }

    @Override
    protected Long getId(MultiplePaddock multiplePaddock) {
        return multiplePaddock.getId();
    }
}
