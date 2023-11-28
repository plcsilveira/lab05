package ifma.edu.labbd.locadora.modelo;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;
@Entity
@Data
public class Locacao implements EntidadeBase<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locacao_id")
    private Integer id;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "locacao")
    private List<ItemLocacao> itensLocacao = new ArrayList<ItemLocacao>();

}