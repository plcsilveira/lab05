package ifma.edu.labbd.locadora.modelo;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class JogoPlataforma {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal precoDiario;
}
