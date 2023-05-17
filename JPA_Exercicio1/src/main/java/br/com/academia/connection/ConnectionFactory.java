package br.com.academia.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory { //gerenciar instâncias de EntityManager
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbjpaluizdaniel");

    public EntityManager getConnection(){
        return emf.createEntityManager();
    }
}
