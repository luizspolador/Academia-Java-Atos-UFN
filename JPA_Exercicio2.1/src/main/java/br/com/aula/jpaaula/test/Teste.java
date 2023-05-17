package br.com.aula.jpaaula.test;

import br.com.aula.jpaaula.dao.DepartmentDAO;
import br.com.aula.jpaaula.dao.EmployeeDAO;
import br.com.aula.jpaaula.entidades.Department;
import br.com.aula.jpaaula.entidades.Employee;

public class Teste {
    public static void main(String[] args) {
        Department department = new Department();
        Employee employee = new Employee();

        DepartmentDAO ddao = new DepartmentDAO();
        EmployeeDAO edao = new EmployeeDAO();

//        //salvando..
//        department.setName("Tecnologia");
//        ddao.save(department);
//
//        employee.setCompany("UEPG");
//        employee.setDepartment(department);
//        employee.setName("Daniel");
//        employee.setSalary(2000);
//
//        edao.save(employee);
//
        // pesquisando pelo id
//        department = ddao.findById(1);
//        System.out.println(department);
//
//        employee = edao.findById(1);
//        System.out.println(employee);

        // pesquisando todos os departamentos e empregados
//        for(Department department1 : ddao.findAll()){
//            System.out.println(department1);
//        }
//
//        for(Employee employee1 : edao.findAll()){
//            System.out.println(employee1);
//        }
        // removendo employee
        //edao.remove(2);


        //removendo department
        //ddao.remove(1);

    }
}
