package br.com.academia.model.dao;

import br.com.academia.connection.ConnectionFactory;
import br.com.academia.model.Categoria;
import br.com.academia.model.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO {

    public Produto save(Produto produto){
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
            if(produto.getId() == null){ // se não existir um id
                em.persist(produto);
            } else { // se já existir um id
                em.merge(produto);
            }
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback(); // desfaz tudo
        } finally {
            em.close();
        }
        return produto;
    }

    public Produto findById(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        Produto produto = null;
        try{
            produto = em.find(Produto.class, id);
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return produto;
    }

    public List<Produto> findAll(){
        EntityManager em = new ConnectionFactory().getConnection();
        List<Produto> produtos = null;
        try {
            //usando jpql
            String query = "from Produto ";
            produtos = em.createQuery(query).getResultList();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return produtos;
    }

    public Produto remove(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        Produto produto = null;
        try {
            produto = em.find(Produto.class, id);
            em.getTransaction().begin();
            em.remove(produto);
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return produto;
    }
}
