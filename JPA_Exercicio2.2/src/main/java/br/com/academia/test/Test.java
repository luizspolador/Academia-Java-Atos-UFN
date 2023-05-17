package br.com.academia.test;

import br.com.academia.dao.DepartmentDao;
import br.com.academia.dao.EmployeeDao;
import br.com.academia.model.Department;
import br.com.academia.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // Criação do EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("aulajpa3");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Criação das instâncias dos Daos
        DepartmentDao departmentDao = new DepartmentDao(entityManager);
        EmployeeDao employeeDao = new EmployeeDao(entityManager);

        // Criação de objetos de exemplo
//        Department department1 = new Department();
//        department1.setName("Department 1");
//
//        Department department2 = new Department();
//        department2.setName("Department 2");
//
//        Employee employee1 = new Employee();
//        employee1.setName("Employee 1");
//        employee1.setSalary("5000");
//        employee1.setCompany("Company A");
//        employee1.getDepartments().add(department1);
//
//        Employee employee2 = new Employee();
//        employee2.setName("Employee 2");
//        employee2.setSalary("4000");
//        employee2.setCompany("Company B");
//        employee2.getDepartments().add(department2); //

        // Salvando os objetos no banco de dados
//        departmentDao.salvar(department1);
//        departmentDao.salvar(department2);
//        employeeDao.salvar(employee1);
//        employeeDao.salvar(employee2);

        // Listar por ID
//        Department retrievedDepartment = departmentDao.listarPorId(1);
//        System.out.println("Departamento recuperado por ID: " + retrievedDepartment.getName());
//
//        Employee retrievedEmployee = employeeDao.listarPorId(2);
//        System.out.println("Funcionário recuperado por ID: " + retrievedEmployee.getName());
//
//        // Listar todos
//        List<Department> departments = departmentDao.listarTodos();
//        System.out.println("Lista de Departamentos:");
//        for (Department department : departments) {
//            System.out.println("- " + department.getName());
//        }
//
//        List<Employee> employees = employeeDao.listarTodos();
//        System.out.println("Lista de Funcionários:");
//        for (Employee employee : employees) {
//            System.out.println("- " + employee.getName());
//        }

//        // Deletar objeto
        //departmentDao.deletarPorId(4);
        //employeeDao.deletarPorId(4); // primeiro executar esse

        // Fechando o EntityManager
        entityManager.close();
        entityManagerFactory.close();
    }
}
