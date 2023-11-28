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
            Jogo jogoExistente = daoJogo.buscaPorNome(jogo.getTitulo());
            Plataforma plataformaExistente = daoPlataforma.buscaPorNome(plataforma.getNome());
            if(jogoExistente == null){
                jogoExistente  =  daoJogo.salvaOuAtualiza(jogo);
            }
            if(plataformaExistente == null){
                plataformaExistente = daoPlataforma.salvaOuAtualiza(plataforma);
            }

            JogoPlataformaId plataformaJogoId = new JogoPlataformaId();
            plataformaJogoId.setJogoId(jogoExistente.getId());
            plataformaJogoId.setPlataformaId(plataformaExistente.getId());

            JogoPlataforma plataformaJogo = new JogoPlataforma();
            plataformaJogo.setPrecoDiario(preco);
            plataformaJogo.setPlataforma(plataformaExistente);
            plataformaJogo.setJogo(jogoExistente);
            plataformaJogo.setId(plataformaJogoId);

            daoJogoPlataforma.salvaOuAtualiza(plataformaJogo);
            jogo.getPlataformas().add(plataformaJogo);
            plataforma.getJogos().add(plataformaJogo);

            manager.getTransaction().commit();
            System.out.println("Jogo cadastrado com sucesso");
            return jogoExistente;
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            manager.close();
        }
    }

    public static void main(String[] args) throws Exception{
        Jogo jogo = new Jogo();
        jogo.setTitulo("Resedente Evil");
        Plataforma plataforma = new Plataforma();
        plataforma.setNome("Xbox");
        CadastrarJogo cj = new CadastrarJogo();
        cj.CadastrarJogo(jogo, plataforma, BigDecimal.valueOf(10));
    }
}
