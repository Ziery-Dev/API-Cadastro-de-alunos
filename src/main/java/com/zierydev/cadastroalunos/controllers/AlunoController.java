package com.zierydev.cadastroalunos.controllers;

import com.zierydev.cadastroalunos.dtos.AlunoDto;
import com.zierydev.cadastroalunos.entities.Aluno;
import com.zierydev.cadastroalunos.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    //Salvar dadps de um alump
    @PostMapping
    public ResponseEntity<Aluno> salvarAluno(@RequestBody @Valid AlunoDto alunoDto) {
        Aluno alunoSave = alunoService.saveAluno(alunoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSave);
    }


    //Buscar todos alunos (testado: ok)
    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAlunos() {
        List <Aluno> alunos = alunoService.findAllAlunos();
        return ResponseEntity.status(HttpStatus.OK).body(alunos);
    }

    //Buscar aluno por id (testado: ok)
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable Long id) {
        Aluno alunoGet = alunoService.findAlunoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(alunoGet);
    }

    //Deletar informação de um aluno pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAluno(@PathVariable Long id) {
        String msg = alunoService.deleteAlunoById(id);
        return ResponseEntity.ok(msg);
    }

    //Atualizar dados de um aluno
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable(name = "id") Long id, @RequestBody @Valid AlunoDto alunoDto) {
        var alunoUpdate = alunoService.updateAluno(id, alunoDto);
        return ResponseEntity.ok(alunoUpdate);
    }

    //filtrar aluno por curso
    @GetMapping("/curso/{curso}")
    public ResponseEntity<List<Aluno>> getAlunoByCurso(@PathVariable(name = "curso") String curso) {
        var alunos = alunoService.findAlunoByCurso(curso);
        return  ResponseEntity.ok(alunos);
    }


}
