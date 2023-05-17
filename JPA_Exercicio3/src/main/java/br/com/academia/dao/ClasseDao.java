package br.com.academia.dao;

import br.com.academia.model.Classe;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ClasseDao {
    private EntityManager em;

    public ClasseDao(EntityManager em){
        this.em = em;
    }

    //salva classe
    public void salvar (Classe classe){
        em.getTransaction().begin();
        em.persist(classe);
        em.getTransaction().commit();
    }

    //lista a classe por id
    public Classe listarPorId(Integer id){
        return em.find(Classe.class, id);
    }

    //lista todas as classes
    public List<Classe> listarTodas(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Classe> cq = cb.createQuery(Classe.class);
        Root<Classe> rootEntry = cq.from(Classe.class);
        CriteriaQuery<Classe> all = cq.select((rootEntry));
        TypedQuery<Classe> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    //deletar uma classe por id
    public void deletarPorId(Integer id){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Classe classe = em.find(Classe.class, id);
        if(classe != null){
            em.remove(classe);
        }
        transaction.commit();
    }

}
