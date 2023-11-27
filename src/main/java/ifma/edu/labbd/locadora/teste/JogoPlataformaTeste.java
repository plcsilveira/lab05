package ifma.edu.labbd.locadora.teste;

import ifma.edu.labbd.locadora.modelo.Jogo;
import ifma.edu.labbd.locadora.modelo.JogoPlataforma;
import ifma.edu.labbd.locadora.modelo.JogoPlataformaId;
import ifma.edu.labbd.locadora.modelo.Plataforma;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class JogoPlataformaTeste {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab05_jpa");
        EntityManager manager = factory.createEntityManager();

        // Teste de cadastro de jogo
        Jogo jogo = new Jogo();
        jogo.setTitulo("PES 2023");

        // Teste de cadastro de plataforma e associação com o jogo
        Plataforma plataforma = new Plataforma();
        plataforma.setNome("Xbox");

        manager.getTransaction().begin();
        manager.persist(jogo);
        manager.persist(plataforma);
        manager.getTransaction().commit();

        JogoPlataformaId plataformaJogoId = new JogoPlataformaId(); // Instanciar JogoPlataformaId
        plataformaJogoId.setJogoId(jogo.getId()); // Definir o jogoId
        plataformaJogoId.setPlataformaId(plataforma.getId()); // Definir o plataformaId


        JogoPlataforma plataformaJogo = new JogoPlataforma();
        plataformaJogo.setPrecoDiario(BigDecimal.valueOf(15.99));
        plataformaJogo.setPlataforma(plataforma);
        plataformaJogo.setJogo(jogo);
        plataformaJogo.setId(plataformaJogoId);

        manager.getTransaction().begin();
        manager.persist(plataformaJogo);
        manager.getTransaction().commit();

        // Outros testes...

        manager.close();
        factory.close();
    }
}
