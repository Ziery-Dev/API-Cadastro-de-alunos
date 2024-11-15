package com.zierydev.cadastroalunos.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


public record AlunoDto(@NotBlank String nome, @Positive int idade, @NotBlank String curso, @NotBlank String matricula) {


    @Override
    public @NotBlank String matricula() {
        return matricula;
    }

    @Override
    public @NotBlank String curso() {
        return curso;
    }

    @Override
    @Positive
    public int idade() {
        return idade;
    }

    @Override
    public @NotBlank String nome() {
        return nome;
    }
}

