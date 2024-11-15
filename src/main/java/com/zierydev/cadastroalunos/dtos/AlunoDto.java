package com.zierydev.cadastroalunos.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public record AlunoDto(@NotBlank String nome, @Positive int idade, @NotBlank String curso, @NotBlank String matricula) {

}

