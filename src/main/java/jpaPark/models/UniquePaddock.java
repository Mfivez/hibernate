package jpaPark.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("0")
public class UniquePaddock extends Paddock {

    //cette Entity va hériter de l'entité Paddock

    @OneToOne
    @JoinColumn(name = "paddock_unique_species")
    private Specie specie;
}
