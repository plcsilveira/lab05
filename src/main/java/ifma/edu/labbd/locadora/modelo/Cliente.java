package ifma.edu.labbd.locadora.modelo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
public class Cliente implements EntidadeBase<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Integer id;

    private String nome;
    private String email;
    private String telefone;
    private String senha;

    @OneToMany(mappedBy = "cliente")
    private List<Locacao> locacoes = new ArrayList<Locacao>();

    @OneToMany(mappedBy = "cliente")
    private List<ConsolePorCliente> consolesPorCliente = new ArrayList<ConsolePorCliente>();

    public Cliente(String nome, String email, String telefone, String senha){
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
    }
    public Cliente(){

    }
}
