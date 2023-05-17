package br.com.aula.jpaaula.dao;

import br.com.aula.jpaaula.connection.ConnectionFactory;
import br.com.aula.jpaaula.entidades.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeDAO {
    public Employee save(Employee employee){
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
            if(employee.getId() == null){ // se não existir um id
                em.persist(employee);
            } else { // se já existir um id
                em.merge(employee);
            }
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback(); // desfaz tudo
        } finally {
            em.close();
        }
        return employee;
    }

    public Employee findById(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        Employee employee = null;
        try{
            employee = em.find(Employee.class, id);
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return employee;
    }

    public List<Employee> findAll(){
        EntityManager em = new ConnectionFactory().getConnection();
        List<Employee> employee = null;
        try {
            //usando jpql
            String query = "from Employee ";
            employee = em.createQuery(query).getResultList();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return employee;
    }

    public Employee remove(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        Employee employee = null;
        try {
            employee = em.find(Employee.class, id);
            em.getTransaction().begin();
            em.remove(employee);
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return employee;
    }
}
