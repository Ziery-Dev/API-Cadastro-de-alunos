package com.zierydev.cadastroalunos.respositories;

import com.zierydev.cadastroalunos.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    //filtra alunos por curso
    List<Aluno> findByCurso(String curso);

    //filtrar por matricula
    Optional<Aluno> findByMatricula(String matricula);
}
