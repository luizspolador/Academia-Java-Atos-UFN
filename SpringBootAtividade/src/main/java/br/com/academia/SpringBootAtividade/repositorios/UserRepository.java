package br.com.academia.SpringBootAtividade.repositorios;

import br.com.academia.SpringBootAtividade.entidades.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

// fornece todos os métodos necessários para o crud
public interface UserRepository extends JpaRepository<Professor, Long> {

}
