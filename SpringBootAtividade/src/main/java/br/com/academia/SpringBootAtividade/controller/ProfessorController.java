package br.com.academia.SpringBootAtividade.controller;

import br.com.academia.SpringBootAtividade.entidades.Professor;
import br.com.academia.SpringBootAtividade.repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorController {

    @Autowired
    private UserRepository repository;

    @GetMapping// para a requisição web
    public List<Professor> findAll(){
        List<Professor> professores = repository.findAll(); // consulta e retorna uma lista
        return professores; // consigo verificar no formato JSON no próprio navegador ao utilizar http://localhost:8080/professores
    }

    @GetMapping(value = "/{id}") //  o caminho será /professores/id (numero)
    public Professor findById(@PathVariable Long id){
        Professor professores = repository.findById(id).get(); // retorna um Optional por isso a necessidade de utilizar o .get()
        return professores;
    }

    @PostMapping
    public Professor Insert(@RequestBody Professor professor){ // passo o corpo da requisição como parâmetro
        Professor professores = repository.save(professor);
        return professores;
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id) {  // http://localhost:8080/professores/id (numero)
        repository.deleteById(id);
        return "Professor com id " + id + " deletado com sucesso";
    }
}
