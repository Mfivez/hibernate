package jpaPark.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "paddocks")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paddock {
    @Id
    @Column(name = "id_paddock")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_paddock")
    private String name;
    @Column(name = "area_paddock")
    private double area;
    @OneToMany(mappedBy = "paddock")
    private List<Dinosaur> dinosaurList;
    @ManyToMany
    @JoinTable(name = "paddock_employes",
                joinColumns = @JoinColumn(name = "id_employes"),
                inverseJoinColumns = @JoinColumn(name = "id_paddock"))
    private List<Employe>employeList;
    @OneToOne
    @JoinColumn(name = "species_id")
    private Specie specie;


}
