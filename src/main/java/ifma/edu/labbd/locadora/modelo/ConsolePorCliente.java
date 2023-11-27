package ifma.edu.labbd.locadora.modelo;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class ConsolePorCliente implements EntidadeBase<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type = "integer")
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
