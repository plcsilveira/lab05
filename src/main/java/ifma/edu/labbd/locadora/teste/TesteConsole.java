package ifma.edu.labbd.locadora.teste;

import ifma.edu.labbd.locadora.modelo.Console;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class TesteConsole {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab05_jpa");
        EntityManager manager = factory.createEntityManager();

        // Teste de cadastro de console
        Console console = new Console();
        console.setNome("PlayStation 5");
        console.setPrecoPorHora(BigDecimal.valueOf(10.0));

        manager.getTransaction().begin();
        manager.persist(console);
        manager.getTransaction().commit();

        // Outros testes...

        manager.close();
        factory.close();
    }
}
