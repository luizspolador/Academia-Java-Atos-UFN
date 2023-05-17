package br.com.academia.test;

import br.com.academia.dao.ClasseDao;
import br.com.academia.dao.ProfessorDao;
import br.com.academia.model.Classe;
import br.com.academia.model.Professor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // Criação do EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexercicio3");
        EntityManager em = emf.createEntityManager();

        // Criação das instâncias dos Daos
        ClasseDao classeDao = new ClasseDao(em);
        ProfessorDao professorDao = new ProfessorDao(em);

        // Criação de objetos de exemplo
//        Classe classe1 = new Classe();
//        classe1.setCnome("Classe 3");
//
//        Classe classe2 = new Classe();
//        classe2.setCnome("Classe 4");
//
//        Professor professor1 = new Professor();
//        professor1.setTnome("José");
//        professor1.setAssunto("assunto");
//        professor1.getClasses().add(classe1);
//
//        Professor professor2 = new Professor();
//        professor2.setTnome("Maria");
//        professor2.setAssunto("assuntinho");
//        professor2.getClasses().add(classe2);


        // Salvando os objetos no banco de dados
//        classeDao.salvar(classe1);
//        classeDao.salvar(classe2);
//        professorDao.salvar(professor1);
//        professorDao.salvar(professor2);

        // Listar por ID
//        Classe retrievedDepartment = classeDao.listarPorId(3);
//        System.out.println("Classe recuperada por ID: " + retrievedDepartment.getCnome());
//
//        Professor retrievedEmployee = professorDao.listarPorId(4);
//        System.out.println("Professor recuperado por ID: " + retrievedEmployee.getTnome());

        // Listar todos
//        List<Classe> classes = classeDao.listarTodas();
//        System.out.println("Lista de classes:");
//        for (Classe classe : classes) {
//            System.out.println("- " + classe.getCnome());
//        }
//
//        List<Professor> professores = professorDao.listarTodas();
//        System.out.println("Lista de professores:");
//        for (Professor professor : professores) {
//            System.out.println("- " + professor.getTnome());
//        }

      // Deletar objeto
        //classeDao.deletarPorId(4);
        //professorDao.deletarPorId(4); // primeiro executar esse

        // Fechando o EntityManager
        em.close();
        emf.close();
    }
}

