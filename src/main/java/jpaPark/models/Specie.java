package jpaPark.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity // pour spéficier que la table est une entity
@Table (name = "species") // le nom qu'on veut donner à la table
@Getter @Setter // générer les getter et setter
@AllArgsConstructor // générer un constructeur avec tous les arguments
@NoArgsConstructor //générer un constructeur par défaut
public class Specie implements WithId <Long> {
    @Id //je spécifie que la variable est un id
    @Column(name = "species_id") // je lui donne un nom
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // je spéficie que l'id sera auto incrémenté
    private Long id;
    @Column(name = "species_name")
    private String name;
    @Enumerated(EnumType.STRING) // je viens lui passer l'annotion Enumerated pour spéficier que c'est une énum basée sur mon enumération EnumDiet
    private EnumDiet enumDiet;
    @OneToMany(mappedBy = "specie")
    private List<Dinosaur> dinosaurList;

    @ManyToOne
    @JoinColumn(name = "espece_enclos_m")
    private MultiplePaddock multiplePaddock;

    @OneToOne(mappedBy = "specie")
    private UniquePaddock uniquePaddock;




}
