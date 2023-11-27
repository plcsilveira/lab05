package ifma.edu.labbd.locadora.DAO;

import ifma.edu.labbd.locadora.modelo.ItemLocacao;

import javax.persistence.EntityManager;

public class DAOItemLocacao {
    private final EntityManager manager;
    private final DAOGenerico<ItemLocacao> daoGenerico;

    public DAOItemLocacao(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public ItemLocacao buscaPor(Integer id) {
        return daoGenerico.buscaPorId(ItemLocacao.class, id);
    }

    public ItemLocacao salvaOuAtualiza(ItemLocacao t) {
        return daoGenerico.salvaOuAtualiza(t);
    }

    public void remove(ItemLocacao t) {
        daoGenerico.remove(t);
    }
}

