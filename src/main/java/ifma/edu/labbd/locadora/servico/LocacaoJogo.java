package ifma.edu.labbd.locadora.servico;

import ifma.edu.labbd.locadora.DAO.*;
import ifma.edu.labbd.locadora.EMFactory;
import ifma.edu.labbd.locadora.modelo.*;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocacaoJogo {
    private final EntityManager manager;
    private final DAOJogo daoJogo;
    private final DAOPlataforma daoPlataforma;
    private final DAOJogoPlataforma daoJogoPlataforma;
    private final DAOCliente daoCliente;
    private final DAOLocacao daoLocacao;
    private final DAOItemLocacao daoItemLocacao;

    public LocacaoJogo() {
        this.manager = new EMFactory().getEntityManager();
        this.daoJogo = new DAOJogo(manager);
        this.daoItemLocacao = new DAOItemLocacao(manager);
        this.daoLocacao = new DAOLocacao(manager);
        this.daoPlataforma = new DAOPlataforma(manager);
        this.daoCliente = new DAOCliente(manager);
        this.daoJogoPlataforma = new DAOJogoPlataforma(manager);
    }

    public BigDecimal RealizarLocacao(List<Jogo> jogos, Plataforma plataforma, Cliente cliente, Integer dias) {
        manager.getTransaction().begin();
        cliente = daoCliente.buscaPor(cliente.getId());
        plataforma = daoPlataforma.buscaPor(plataforma.getId());
        jogos = daoJogo.consultarTodosOsJogos();
        jogos.remove(jogos.get(0));
        BigDecimal precoFinal = BigDecimal.ZERO;
        try {
            Cliente clientePersistido = daoCliente.buscaPor(cliente.getId());
            if (clientePersistido == null) {
                throw new RuntimeException("O cliente deve estar cadastrado no sistema para realizar uma locacao");
            }

            Locacao locacao = new Locacao();
            locacao.setCliente(clientePersistido);
            locacao.setData(LocalDate.now());

            for (Jogo jogo : jogos) {
                JogoPlataforma jogoPlataforma = daoJogoPlataforma.buscaPorJogoEPlataforma(jogo, plataforma);

                if (daoJogoPlataforma.consultarDisponibilidadeJogo(jogo, plataforma)) {
                    ItemLocacao itemLocacao = new ItemLocacao();
                    itemLocacao.setDias(dias);
                    itemLocacao.setJogoPlataforma(jogoPlataforma);
                    locacao.getItensLocacao().add(itemLocacao);
                    daoLocacao.salvaOuAtualiza(locacao);
                    itemLocacao.setLocacao(locacao);
                    daoItemLocacao.salvaOuAtualiza(itemLocacao);
                    precoFinal = precoFinal.add(jogoPlataforma.getPrecoDiario().multiply(BigDecimal.valueOf(dias)));
                } else {
                    throw new RuntimeException("Jogo: " + jogo.getTitulo() + " não disponível para essa plataforma!");
                }
            }
            daoLocacao.salvaOuAtualiza(locacao);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
        return precoFinal;
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setId(3);
        Plataforma plataforma = new Plataforma();
        plataforma.setId(4);
        List<Jogo> jogos = new ArrayList<Jogo>();
        LocacaoJogo locacao = new LocacaoJogo();
        locacao.RealizarLocacao(jogos, plataforma, cliente, 10);
    }
}
