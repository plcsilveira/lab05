package ifma.edu.labbd.locadora.modelo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Plataforma implements EntidadeBase <Integer>{
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plataforma_id")
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "plataforma")
    private List<JogoPlataforma> jogos = new ArrayList<>();


}
