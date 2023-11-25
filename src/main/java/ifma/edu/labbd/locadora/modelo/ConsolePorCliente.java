package ifma.edu.labbd.locadora.modelo;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class ConsolePorCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime inicio;
    private LocalDateTime fim;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "console_id")
    private Console console;
}
