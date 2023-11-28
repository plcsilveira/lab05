package ifma.edu.labbd.locadora.modelo;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
@Embeddable
@Data
@EqualsAndHashCode
public class JogoPlataformaId implements Serializable {
    private Integer jogoId;
    private Integer plataformaId;
}
