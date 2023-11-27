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
            if (jogo.getId() != null) {
                Jogo jogoExistente = daoJogo.buscaPor(jogo.getId());
                if (Objects.nonNull(jogoExistente) && !Objects.equals(jogo, jogoExistente)) {
                    throw new Exception("Jogo já cadastrado");
                }
            }
            if (plataforma.getId() != null) {
                Plataforma plataformaExistente = daoPlataforma.buscaPor(plataforma.getId());
                if (Objects.nonNull(plataformaExistente) && !Objects.equals(plataforma, plataformaExistente)) {
                    throw new Exception("Plataforma já cadastrado");
                }
            }
            Jogo jogoSalvo = daoJogo.salvaOuAtualiza(jogo);
            daoPlataforma.salvaOuAtualiza(plataforma);
            JogoPlataformaId plataformaJogoId = new JogoPlataformaId();
            plataformaJogoId.setJogoId(jogo.getId());
            plataformaJogoId.setPlataformaId(plataforma.getId());
            JogoPlataforma plataformaJogo = new JogoPlataforma();
            plataformaJogo.setPrecoDiario(preco);
            plataformaJogo.setPlataforma(plataforma);
            plataformaJogo.setJogo(jogo);
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
        jogo.setTitulo("Call Of Duty");
        Plataforma plataforma = new Plataforma();
        plataforma.setNome("Xbox");
        CadastrarJogo cj = new CadastrarJogo();
        cj.CadastrarJogo(jogo, plataforma, BigDecimal.valueOf(10));
    }
}
