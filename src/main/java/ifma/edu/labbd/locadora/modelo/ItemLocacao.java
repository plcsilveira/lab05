package ifma.edu.labbd.locadora.modelo;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
public class ItemLocacao implements EntidadeBase<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemLocacao_id")
    private Integer id;

    private Integer dias;
    private Integer quantidade;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "jogo_id", referencedColumnName = "jogo_id"), // Substitua pelos nomes reais das colunas
            @JoinColumn(name = "plataforma_id", referencedColumnName = "plataforma_id")
    })
    private JogoPlataforma jogoPlataforma;

    @ManyToOne
    @JoinColumn(name = "locacao_id")
    private Locacao locacao;
}
