package ifma.edu.labbd.locadora.DAO;

import ifma.edu.labbd.locadora.modelo.Plataforma;

import javax.persistence.EntityManager;

public class DAOPlataforma {
    private final EntityManager manager;
    private final DAOGenerico<Plataforma> daoGenerico;

    public DAOPlataforma(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Plataforma buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Plataforma.class, id);
    }

    public Plataforma salvaOuAtualiza(Plataforma t) {
        return daoGenerico.salvaOuAtualiza(t);
    }

    public void remove(Plataforma t) {
        daoGenerico.remove(t);
    }
}
