package ifma.edu.labbd.locadora.teste;

import ifma.edu.labbd.locadora.modelo.Acessorio;
import ifma.edu.labbd.locadora.modelo.Console;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class TesteConsoleAcessorio {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab05_jpa");
        EntityManager manager = factory.createEntityManager();

        // Criando um console
        Console console = new Console();
        console.setNome("PlayStation 4");
        console.setPrecoPorHora(BigDecimal.valueOf(20.0));

        // Criando um acessório
        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Controle sem fio");

        // Adicionando a associação à lista de ConsoleAcessorio no Console e no Acessorio
        console.getAcessorios().add(acessorio);
        acessorio.getConsoles().add(console);

        // Iniciando a transação e persistindo as entidades
        manager.getTransaction().begin();
        manager.persist(console);
        manager.persist(acessorio);
        manager.getTransaction().commit();

        // Fechando o EntityManager e a EntityManagerFactory
        manager.close();
        factory.close();
    }
}
