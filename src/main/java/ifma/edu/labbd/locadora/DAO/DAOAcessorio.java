package ifma.edu.labbd.locadora.DAO;

import ifma.edu.labbd.locadora.modelo.Acessorio;

import javax.persistence.EntityManager;

public class DAOAcessorio {
    private final EntityManager manager;
    private final DAOGenerico<Acessorio> daoGenerico;

    public DAOAcessorio(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Acessorio buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Acessorio.class, id);
    }

    public Acessorio salvaOuAtualiza(Acessorio t) {
        return daoGenerico.salvaOuAtualiza(t);
    }

    public void remove(Acessorio t) {
        daoGenerico.remove(t);
    }
}
