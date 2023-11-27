package ifma.edu.labbd.locadora.teste;

import ifma.edu.labbd.locadora.modelo.Acessorio;
import ifma.edu.labbd.locadora.modelo.Console;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteAcessorio {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab05_jpa");
        EntityManager manager = factory.createEntityManager();

        // Teste de cadastro de acessório
        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Controle adicional");

        manager.getTransaction().begin();
        manager.persist(acessorio);
        manager.getTransaction().commit();

        // Outros testes...

        manager.close();
        factory.close();
    }
}
