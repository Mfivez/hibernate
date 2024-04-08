package jpaPark.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "dinosaurs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dinosaur {
    @Id
    @Column(name = "id_dinosaur")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "dinosaur_name")
    private String nom;
    @Column(name = "dinosaur_sex")
    private String sex;
    @ManyToOne
    @JoinColumn(name = "id_specie",nullable = false)
    private Specie specie;
    @ManyToOne
    @JoinColumn(name = "id_paddock",nullable = false)
    private Paddock paddock;
}
