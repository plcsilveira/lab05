package ifma.edu.labbd.locadora.modelo;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity

public class Jogo implements EntidadeBase<Integer>{

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jogo_id")
    private Integer id;

    private String titulo;

    @OneToMany(mappedBy = "jogo")
    private List<JogoPlataforma> plataformas = new ArrayList<JogoPlataforma>();

}
