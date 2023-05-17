package br.com.aula.jpaaula.entidades;

import javax.persistence.*;

@Entity
public class Employee {

    @Id /*chave primaria */
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double salary;
    private String company;
    @OneToOne
    private Department department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee -> id: " + getId() + ", nome: " + getName() + ", salário: " + getSalary() + ", empresa: " + getCompany()
                + ", nome do departamento: " + getDepartment();
    }
}
