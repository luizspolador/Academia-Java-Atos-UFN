package br.com.academia.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "professores")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    private String tnome;
    private String assunto;

    @ManyToMany
    @JoinTable(
            name = "professor_classe",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "classe_id")
    )
    private Set<Classe> classes = new HashSet<>();

    public Professor(){}

    public Professor(String tnome, String assunto, Set<Classe> classes) {
        this.tnome = tnome;
        this.assunto = assunto;
        this.classes = classes;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTnome() {
        return tnome;
    }

    public void setTnome(String tnome) {
        this.tnome = tnome;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Set<Classe> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classe> classes) {
        this.classes = classes;
    }
}
