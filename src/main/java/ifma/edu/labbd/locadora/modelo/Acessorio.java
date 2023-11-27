package ifma.edu.labbd.locadora.modelo;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
public class Acessorio implements EntidadeBase<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acessorio_id")
    private Integer id;

    private String nome;

    @ManyToMany(mappedBy = "acessorios")
    private List<Console> consoles;

    public Acessorio(){
        this.consoles = new ArrayList<Console>();
    }
}
