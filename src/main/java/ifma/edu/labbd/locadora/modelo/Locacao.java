package ifma.edu.labbd.locadora.modelo;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;
@Entity
@Data
public class Locacao implements EntidadeBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "locacao")
    private List<ItemLocacao> itensLocacao;

}