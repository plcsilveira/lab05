package ifma.edu.labbd.locadora.modelo;

import lombok.Data;
import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class Acessorio implements EntidadeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToMany(mappedBy = "acessorios")
    private List<Console> consoles;
}
