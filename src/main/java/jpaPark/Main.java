package jpaPark;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpaPark.models.MultiplePaddock;
import jpaPark.models.UniquePaddock;
import jpaPark.repository.EnclosMultipleRepository;
import jpaPark.repository.PaddockRepository;
import jpaPark.repository.SpeciesRepository;
import jpaPark.repository.UniquePaddockRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpapark");
//        emf.close();

        PaddockRepository enclosRepo = new PaddockRepository(emf);
        UniquePaddockRepository esr = new UniquePaddockRepository(emf);
        EnclosMultipleRepository emr = new EnclosMultipleRepository(emf);
        SpeciesRepository especeRepo = new SpeciesRepository(emf);

        List<UniquePaddock> enclosSimples = esr.findAll();
        List<MultiplePaddock> enclosMultiples = emr.findAll();

        System.out.println("-- Enclos simple -- ");
        enclosSimples.forEach(System.out::println);

        System.out.println("-- Enclos multiple -- ");
        enclosMultiples.forEach(System.out::println);

        emf.close();

    }
}