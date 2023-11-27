package ifma.edu.labbd.locadora.DAO;

import ifma.edu.labbd.locadora.modelo.Cliente;

import javax.persistence.EntityManager;

public class DAOCliente {
    private final EntityManager manager;
    private final DAOGenerico<Cliente> daoGenerico;
    public DAOCliente(EntityManager manager){
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Cliente buscaPor(Integer id){
        return daoGenerico.buscaPorId(Cliente.class, id);
    }
    public Cliente salvaOuAtualiza(Cliente t){
        return daoGenerico.salvaOuAtualiza(t);
    }
    public void remove(Cliente t){
        daoGenerico.remove(t);
    }
}
