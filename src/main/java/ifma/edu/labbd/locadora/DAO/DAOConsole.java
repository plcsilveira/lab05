package ifma.edu.labbd.locadora.DAO;

import ifma.edu.labbd.locadora.modelo.Console;

import javax.persistence.EntityManager;

public class DAOConsole {
    private final EntityManager manager;
    private final DAOGenerico<Console> daoGenerico;

    public DAOConsole(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Console buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Console.class, id);
    }

    public Console salvaOuAtualiza(Console t) {
        return daoGenerico.salvaOuAtualiza(t);
    }

    public void remove(Console t) {
        daoGenerico.remove(t);
    }
}
