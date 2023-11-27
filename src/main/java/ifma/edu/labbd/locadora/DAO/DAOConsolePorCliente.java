package ifma.edu.labbd.locadora.DAO;

import ifma.edu.labbd.locadora.modelo.ConsolePorCliente;

import javax.persistence.EntityManager;

public class DAOConsolePorCliente {
    private final EntityManager manager;
    private final DAOGenerico<ConsolePorCliente> daoGenerico;

    public DAOConsolePorCliente(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public ConsolePorCliente buscaPor(Integer id) {
        return daoGenerico.buscaPorId(ConsolePorCliente.class, id);
    }

    public ConsolePorCliente salvaOuAtualiza(ConsolePorCliente t) {
        return daoGenerico.salvaOuAtualiza(t);
    }

    public void remove(ConsolePorCliente t) {
        daoGenerico.remove(t);
    }
}

