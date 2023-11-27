package ifma.edu.labbd.locadora.teste;

import ifma.edu.labbd.locadora.modelo.Cliente;
import ifma.edu.labbd.locadora.modelo.Locacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class TesteLocacao {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab05_jpa");
        EntityManager manager = factory.createEntityManager();

        // Teste de cadastro de locação
        Cliente cliente = new Cliente();
        cliente.setNome("Joana");
        cliente.setEmail("joana@gmail.com");
        cliente.setTelefone("33399999");
        cliente.setSenha("senha123");

        manager.getTransaction().begin();
        manager.persist(cliente);
        manager.getTransaction().commit();

        Locacao locacao = new Locacao();
        locacao.setData(LocalDate.now());
        locacao.setCliente(cliente);

        manager.getTransaction().begin();
        manager.persist(locacao);
        manager.getTransaction().commit();

        // Outros testes...

        manager.close();
        factory.close();
    }
}
