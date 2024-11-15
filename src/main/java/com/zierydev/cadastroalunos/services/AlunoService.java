package com.zierydev.cadastroalunos.services;

import com.zierydev.cadastroalunos.dtos.AlunoDto;
import com.zierydev.cadastroalunos.entities.Aluno;
import com.zierydev.cadastroalunos.exceptions.ResourceNotFoundException;
import com.zierydev.cadastroalunos.respositories.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    //criar excessão personalizada ao salvar aluno

    //Salvar novo aluno
    public Aluno saveAluno( AlunoDto alunoDto) {
        var aluno0 = new Aluno(); //cria uma instancia de Aluno
        BeanUtils.copyProperties(alunoDto, aluno0); //converte os dados que estão como dto para aluno
         return alunoRepository.save(aluno0); //realiza o save dos dados no banco
    }

    // Buscar todos alunos
    public List<Aluno> findAllAlunos() {
       List <Aluno> alunos = alunoRepository.findAll();
       if(alunos.isEmpty()){
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A lista de alunos encontra-se vazia");
       }
       return alunos;
    }

    //Buscar aluno por id
    public Aluno findAlunoById(Long id) {
        return alunoRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Aluno com id " + id + " não econtrado"));
    }


    //Deletar dados de um aluno
    public String deleteAlunoById(Long id) {
        Aluno aluno = findAlunoById(id);
        alunoRepository.delete(aluno);
        return "Aluno deletado com sucesso";
    }

    //Atualizar dados do aluno
    public Aluno updateAluno( Long id, AlunoDto alunoDto) {
        Aluno aluno = findAlunoById(id);
        BeanUtils.copyProperties(alunoDto, aluno);
        return alunoRepository.save(aluno);
    }

    //Filtrar alunos por curso
    public List<Aluno> findAlunoByCurso(String curso) {
        List<Aluno> alunos = alunoRepository.findByCurso(curso.toLowerCase());
        if(alunos.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A nenhum aluno encontrado para o curso: " + curso);
        }
        return alunos;

    }



}
