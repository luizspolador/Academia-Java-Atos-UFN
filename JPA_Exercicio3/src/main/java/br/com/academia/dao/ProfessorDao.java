package br.com.academia.dao;

import br.com.academia.model.Professor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProfessorDao {
    private EntityManager em;

    public ProfessorDao(EntityManager em){
        this.em = em;
    }

    //salva professor
    public void salvar (Professor professor){
        em.getTransaction().begin();
        em.persist(professor);
        em.getTransaction().commit();
    }

    //lista a professor por id
    public Professor listarPorId(Integer id){
        return em.find(Professor.class, id);
    }

    //lista todos os professores
    public List<Professor> listarTodas(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Professor> cq = cb.createQuery(Professor.class);
        Root<Professor> rootEntry = cq.from(Professor.class);
        CriteriaQuery<Professor> all = cq.select((rootEntry));
        TypedQuery<Professor> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    //deletar um professor por id
    public void deletarPorId(Integer id){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Professor professor = em.find(Professor.class, id);
        if(professor != null){
            em.remove(professor);
        }
        transaction.commit();
    }
}
