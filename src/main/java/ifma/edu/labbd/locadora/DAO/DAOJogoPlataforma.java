package ifma.edu.labbd.locadora.DAO;

import ifma.edu.labbd.locadora.modelo.Jogo;
import ifma.edu.labbd.locadora.modelo.JogoPlataforma;
import ifma.edu.labbd.locadora.modelo.JogoPlataformaId;
import ifma.edu.labbd.locadora.modelo.Plataforma;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;

public class DAOJogoPlataforma {
    private final EntityManager manager;
    private final DAOGenerico<JogoPlataforma> daoGenerico;

    public DAOJogoPlataforma(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public JogoPlataforma salvaOuAtualiza(JogoPlataforma t) {
        return daoGenerico.salvaOuAtualiza(t);
    }

    public void remove(JogoPlataforma t) {
        daoGenerico.remove(t);
    }

    public boolean consultarDisponibilidadeJogo(Jogo jogo, Plataforma plataforma) {
        JogoPlataformaId jogoplataformaid = new JogoPlataformaId();
        jogoplataformaid.setJogoId(jogo.getId());
        jogoplataformaid.setPlataformaId(plataforma.getId());

        // Consulta se o jogo está disponível na plataforma desejada
        String jpql = "SELECT COUNT(jp) FROM JogoPlataforma jp " +
                "WHERE jp.id = :jogoplataformaid";

        TypedQuery<Long> query = manager.createQuery(jpql, Long.class);
        query.setParameter("jogoplataformaid", jogoplataformaid);

        // Se o resultado for maior que 0, então existe disponibilidade
        return query.getSingleResult() > 0;
    }

    public JogoPlataforma buscaPorJogoEPlataforma(Jogo jogo, Plataforma plataforma) {
        JogoPlataformaId jogoplataformaid = new JogoPlataformaId();
        jogoplataformaid.setJogoId(jogo.getId());
        jogoplataformaid.setPlataformaId(plataforma.getId());

        String jpql = "SELECT jp FROM JogoPlataforma jp " +
                "WHERE jp.id = :jogoplataformaid";

        return manager.createQuery(jpql, JogoPlataforma.class)
                .setParameter("jogoplataformaid", jogoplataformaid)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

}
