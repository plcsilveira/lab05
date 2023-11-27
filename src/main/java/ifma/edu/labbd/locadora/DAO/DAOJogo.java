package ifma.edu.labbd.locadora.DAO;

import ifma.edu.labbd.locadora.modelo.Jogo;

import javax.persistence.EntityManager;

public class DAOJogo {
    private final EntityManager manager;
    private final DAOGenerico<Jogo> daoGenerico;

    public DAOJogo(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Jogo buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Jogo.class, id);
    }

    public Jogo salvaOuAtualiza(Jogo t) {
        return daoGenerico.salvaOuAtualiza(t);
    }

    public void remove(Jogo t) {
        daoGenerico.remove(t);
    }
}
