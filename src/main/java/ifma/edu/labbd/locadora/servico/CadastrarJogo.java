package ifma.edu.labbd.locadora.servico;

import ifma.edu.labbd.locadora.DAO.DAOJogo;
import ifma.edu.labbd.locadora.DAO.DAOJogoPlataforma;
import ifma.edu.labbd.locadora.DAO.DAOPlataforma;
import ifma.edu.labbd.locadora.EMFactory;
import ifma.edu.labbd.locadora.modelo.Jogo;
import ifma.edu.labbd.locadora.modelo.JogoPlataforma;
import ifma.edu.labbd.locadora.modelo.JogoPlataformaId;
import ifma.edu.labbd.locadora.modelo.Plataforma;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class CadastrarJogo {
    private final EntityManager manager;
    private final DAOJogo daoJogo;
    private final DAOPlataforma daoPlataforma;
    private final DAOJogoPlataforma daoJogoPlataforma;

    public CadastrarJogo() {
        this.manager = new EMFactory().getEntityManager();
        this.daoJogo = new DAOJogo(manager);
        this.daoPlataforma = new DAOPlataforma(manager);
        this.daoJogoPlataforma = new DAOJogoPlataforma(manager);
    }

    public Jogo CadastrarJogo(Jogo jogo, Plataforma plataforma, BigDecimal preco) throws Exception {
        try {
            manager.getTransaction().begin();
            JogoPlataforma plataformaJogoExistente = daoJogoPlataforma.buscaPorJogoEPlataforma(jogo, plataforma);
            if (plataformaJogoExistente != null) {
                throw new Exception("Jogo já cadastrado para essa plataforma");
            }

            Jogo jogoSalvo = daoJogo.salvaOuAtualiza(jogo);
            Plataforma plataformaSalva = daoPlataforma.salvaOuAtualiza(plataforma);

            JogoPlataformaId plataformaJogoId = new JogoPlataformaId();
            plataformaJogoId.setJogoId(jogoSalvo.getId());
            plataformaJogoId.setPlataformaId(plataformaSalva.getId());

            JogoPlataforma plataformaJogo = new JogoPlataforma();
            plataformaJogo.setPrecoDiario(preco);
            plataformaJogo.setPlataforma(plataformaSalva);
            plataformaJogo.setJogo(jogoSalvo);
            plataformaJogo.setId(plataformaJogoId);

            daoJogoPlataforma.salvaOuAtualiza(plataformaJogo);
            jogo.getPlataformas().add(plataformaJogo);
            plataforma.getJogos().add(plataformaJogo);

            manager.getTransaction().commit();
            System.out.println("Jogo cadastrado com sucesso");
            return jogoSalvo;
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            manager.close();
        }
    }

    public static void main(String[] args) throws Exception{
        Jogo jogo = new Jogo();
        jogo.setTitulo("Mario Bros");
        Plataforma plataforma = new Plataforma();
        plataforma.setNome("Nitendo");
        CadastrarJogo cj = new CadastrarJogo();
        cj.CadastrarJogo(jogo, plataforma, BigDecimal.valueOf(10));
    }
}
