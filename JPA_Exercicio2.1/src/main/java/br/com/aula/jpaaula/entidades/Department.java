package br.com.aula.jpaaula.entidades;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Integer id;
    private String name;

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

    @Override
    public String toString() {
        return "Departamento: " + getName();
    }
}
