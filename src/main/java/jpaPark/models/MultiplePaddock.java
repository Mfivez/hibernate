package jpaPark.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@DiscriminatorValue("1")
public class MultiplePaddock extends Paddock {

    //cette Entity va hériter de l'entité Paddock
    @OneToMany(mappedBy = "multiplePaddock")
    private List<Specie> specielist;
}
