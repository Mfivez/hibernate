package jpaPark.repository;

import jakarta.persistence.EntityManagerFactory;
import jpaPark.models.Specie;

public class SpeciesRepository extends AbstractRepository <Specie, Long> {

    public SpeciesRepository(EntityManagerFactory emf){
        super(emf,Specie.class);
    }
    @Override
    protected Long getId(Specie specie) {
        return specie.getId();
    }
}
