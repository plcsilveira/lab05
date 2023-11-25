package ifma.edu.labbd.locadora.modelo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class Cliente implements EntidadeBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String telefone;
    private String senha;

    @OneToMany(mappedBy = "cliente")
    private List<Locacao> locacoes;

    @OneToMany(mappedBy = "cliente")
    private List<ConsolePorCliente> consolesPorCliente;
}
