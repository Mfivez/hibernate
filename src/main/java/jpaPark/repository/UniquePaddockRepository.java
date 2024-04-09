package jpaPark.repository;

import jakarta.persistence.EntityManagerFactory;
import jpaPark.models.UniquePaddock;

public class UniquePaddockRepository extends AbstractRepository <UniquePaddock, Long> {

    public UniquePaddockRepository(EntityManagerFactory emf) {
        super(emf, UniquePaddock.class);
    }

    @Override
    protected Long getId(UniquePaddock uniquePaddock) {
        return uniquePaddock.getId();
    }
}
