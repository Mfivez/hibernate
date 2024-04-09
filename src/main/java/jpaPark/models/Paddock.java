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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "paddock_multiple_species", discriminatorType = DiscriminatorType.INTEGER)
public class Paddock implements WithId<Long> {
    @Id
    @Column(name = "id_paddock")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_paddock")
    private String name;
    @Column(name = "area_paddock")
    private double area;
    @OneToMany(mappedBy = "paddock")
    private List<Dinosaur> dinosaurList;
    @ManyToMany
    @JoinTable(name = "paddock")
    private List<Employe>employeList;

    @Override
    public String toString() {
        return "Paddock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", dinosaurList=" + dinosaurList +
                ", employeList=" + employeList +
                '}';
    }


}
