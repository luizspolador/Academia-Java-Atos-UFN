package br.com.aula.jpaaula.dao;

import br.com.aula.jpaaula.connection.ConnectionFactory;
import br.com.aula.jpaaula.entidades.Department;

import javax.persistence.EntityManager;
import java.util.List;

public class DepartmentDAO {
    public Department save(Department department){
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
            if(department.getId() == null){ // se não existir um id
                em.persist(department);
            } else { // se já existir um id
                em.merge(department);
            }
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback(); // desfaz tudo
        } finally {
            em.close();
        }
        return department;
    }

    public Department findById(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        Department department = null;
        try{
            department = em.find(Department.class, id);
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return department;
    }

    public List<Department> findAll(){
        EntityManager em = new ConnectionFactory().getConnection();
        List<Department> department = null;
        try {
            //usando jpql
            String query = "from Department ";
            department = em.createQuery(query).getResultList();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return department;
    }

    public Department remove(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        Department department = null;
        try {
            department = em.find(Department.class, id);
            em.getTransaction().begin();
            em.remove(department);
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return department;
    }
}
