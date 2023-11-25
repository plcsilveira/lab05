package ifma.edu.labbd.locadora.modelo;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
public class ItemLocacao implements EntidadeBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer dias;
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "jogo_plataforma_id")
    private JogoPlataforma jogoPlataforma;

    @ManyToOne
    @JoinColumn(name = "locacao_id")
    private Locacao locacao;
}
