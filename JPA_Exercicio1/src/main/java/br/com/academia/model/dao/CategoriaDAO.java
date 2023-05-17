package br.com.academia.model.dao;

import br.com.academia.connection.ConnectionFactory;
import br.com.academia.model.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDAO {

    //salva e atualiza
    public Categoria save(Categoria categoria){
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
            if(categoria.getId() == null){ // se não existir um id
                em.persist(categoria);
            } else { // se já existir um id
                em.merge(categoria);
            }
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback(); // desfaz tudo
        } finally {
            em.close();
        }
        return categoria;
    }

    // pesquisa por id
    public Categoria findById(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        Categoria categoria = null;
        try{
            categoria = em.find(Categoria.class, id);
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return categoria;
    }

    public List<Categoria> findAll(){
        EntityManager em = new ConnectionFactory().getConnection();
        List<Categoria> categorias = null;
        try {
            //usando jpql
            String query = "from Categoria";
            categorias = em.createQuery(query).getResultList();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return categorias;
    }

    public Categoria remove(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        Categoria categoria = null;
        try {
            categoria = em.find(Categoria.class, id);
            em.getTransaction().begin();
            em.remove(categoria);
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return categoria;
    }

}
