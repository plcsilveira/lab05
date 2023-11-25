package ifma.edu.labbd.locadora.modelo;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Data
public class Console implements EntidadeBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private BigDecimal precoPorHora;

    @OneToMany(mappedBy = "console")
    private List<ConsolePorCliente> consolesPorCliente;

    @ManyToMany
    @JoinTable(
            name = "console_acessorio",
            joinColumns = @JoinColumn(name = "console_id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id")
    )
    private List<Acessorio> acessorios;
}
