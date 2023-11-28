package ifma.edu.labbd.locadora.DAO;

import ifma.edu.labbd.locadora.modelo.Jogo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<Jogo> consultarTodosOsJogos() {
        String jpql = "SELECT j FROM Jogo j";
        TypedQuery<Jogo> query = manager.createQuery(jpql, Jogo.class);
        return query.getResultList();
    }

    public void remove(Jogo t) {
        daoGenerico.remove(t);
    }
}
