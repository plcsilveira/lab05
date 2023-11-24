package ifma.edu.labbd.locadora.modelo;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class JogoPlataforma {

    @EmbeddedId
    private JogoPlataformaId id;

    @ManyToOne
    @MapsId("jogoId")
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;

    @ManyToOne
    @MapsId("plataformaId")
    @JoinColumn(name = "plataforma_id")
    private Plataforma plataforma;

    private BigDecimal precoDiario;

}
