package ifma.edu.labbd.locadora.DAO;

import ifma.edu.labbd.locadora.modelo.JogoPlataforma;

import javax.persistence.EntityManager;

public class DAOJogoPlataforma {
    private final EntityManager manager;
    private final DAOGenerico<JogoPlataforma> daoGenerico;

    public DAOJogoPlataforma(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public JogoPlataforma buscaPor(Integer id) {
        return daoGenerico.buscaPorId(JogoPlataforma.class, id);
    }

    public JogoPlataforma salvaOuAtualiza(JogoPlataforma t) {
        return daoGenerico.salvaOuAtualiza(t);
    }

    public void remove(JogoPlataforma t) {
        daoGenerico.remove(t);
    }
}
