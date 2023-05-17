package br.com.aula.jpaaula.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aulajpa2");

    public EntityManager getConnection(){
        return emf.createEntityManager();
    }
}
