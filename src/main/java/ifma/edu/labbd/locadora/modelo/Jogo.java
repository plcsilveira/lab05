package ifma.edu.labbd.locadora.modelo;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Jogo implements EntidadeBase{

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String titulo;

}
