package com.zierydev.cadastroalunos.respositories;

import com.zierydev.cadastroalunos.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByCurso(String curso);
}
