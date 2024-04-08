package jpaPark.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "employes")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employe {
    @Id
    @Column(name = "id_employes")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "employes_name")
    private String name;
    @Column(name = "employes_last_name")
    private String lastName;
    @ManyToMany(mappedBy = "employeList")
    private List<Paddock> paddockList;
}
