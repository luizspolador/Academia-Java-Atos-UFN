package br.com.academia.dao;

import br.com.academia.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeDao {
    private EntityManager entityManager;

    public EmployeeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    public Employee listarPorId(int id) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> listarTodos() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> rootEntry = cq.from(Employee.class);
        CriteriaQuery<Employee> all = cq.select(rootEntry);
        TypedQuery<Employee> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    public void deletarPorId(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            entityManager.remove(employee);
        }
        transaction.commit();
    }
}
