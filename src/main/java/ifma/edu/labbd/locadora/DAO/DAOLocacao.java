package ifma.edu.labbd.locadora.DAO;

import ifma.edu.labbd.locadora.modelo.Locacao;
import ifma.edu.labbd.locadora.modelo.Plataforma;

import javax.persistence.EntityManager;

public class DAOLocacao {
    private final EntityManager manager;
    private final DAOGenerico<Locacao> daoGenerico;
    public DAOLocacao(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }
    public Locacao buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Locacao.class, id);
    }

    public Locacao salvaOuAtualiza(Locacao t) {
        return daoGenerico.salvaOuAtualiza(t);
    }

    public void remove(Locacao t) {
        daoGenerico.remove(t);
    }
}
