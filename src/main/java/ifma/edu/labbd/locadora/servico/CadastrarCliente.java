package ifma.edu.labbd.locadora.servico;

import ifma.edu.labbd.locadora.DAO.DAOCliente;
import ifma.edu.labbd.locadora.EMFactory;
import ifma.edu.labbd.locadora.modelo.Cliente;

import javax.persistence.EntityManager;
import java.util.Objects;

public class CadastrarCliente {
    private final EntityManager manager;
    private final DAOCliente dao;

    public CadastrarCliente() {
        this.manager = new EMFactory().getEntityManager();
        this.dao = new DAOCliente(manager);
    }

    public Cliente Cadastrar(String nome, String email, String telefone, String senha) throws Exception{
        Cliente cliente = new Cliente(nome, email, telefone, senha);

        try {
            manager.getTransaction().begin();
            if(cliente.getId() != null){
                Cliente clienteExistente = dao.buscaPor(cliente.getId());
                if (Objects.nonNull(clienteExistente) && !Objects.equals(cliente, clienteExistente)) {
                    throw new Exception("Cliente já cadastrado");
                }
            }
            Cliente clienteSalvo = dao.salvaOuAtualiza(cliente);
            manager.getTransaction().commit();
            System.out.println("Cliente cadastrado com sucesso");
            return clienteSalvo;

        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException(e);
        }finally {
            manager.close();
        }
    }

    public static void main(String[] args) throws Exception {
        CadastrarCliente c = new CadastrarCliente();
        c.Cadastrar("Danilo", "danilo123@gmail.com", "98986363", "1234");

    }
}
