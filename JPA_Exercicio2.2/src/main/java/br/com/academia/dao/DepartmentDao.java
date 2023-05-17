package br.com.academia.dao;

import br.com.academia.model.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DepartmentDao {
    private EntityManager entityManager;

    public DepartmentDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Department department) {
        entityManager.getTransaction().begin();
        entityManager.persist(department);
        entityManager.getTransaction().commit();
    }

    public Department listarPorId(int id) {
        return entityManager.find(Department.class, id);
    }

    public List<Department> listarTodos() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Department> cq = cb.createQuery(Department.class);
        Root<Department> rootEntry = cq.from(Department.class);
        CriteriaQuery<Department> all = cq.select(rootEntry);
        TypedQuery<Department> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    public void deletarPorId(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Department department = entityManager.find(Department.class, id);
        if (department != null) {
            entityManager.remove(department);
        }
        transaction.commit();
    }
}
