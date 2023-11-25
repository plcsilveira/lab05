package ifma.edu.labbd.locadora.teste;

import ifma.edu.labbd.locadora.modelo.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteTeste {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab05_jpa");
        EntityManager manager = factory.createEntityManager();
        // Teste de cadastro de cliente
        Cliente cliente = new Cliente();
        cliente.setNome("João");
        cliente.setEmail("joao@gmail.com");
        cliente.setTelefone("999999999");
        cliente.setSenha("senha123");

        manager.getTransaction().begin();
        manager.persist(cliente);
        manager.getTransaction().commit();

        // Teste de busca por ID
        Cliente clienteRecuperado = manager.find(Cliente.class, cliente.getId());
        System.out.println("Cliente recuperado: " + clienteRecuperado);

        // Outros testes...

        manager.close();
        factory.close();
    }
}
