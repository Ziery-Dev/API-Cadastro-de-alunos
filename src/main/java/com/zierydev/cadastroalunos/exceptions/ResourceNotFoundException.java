package com.zierydev.cadastroalunos.exceptions;

//Essa excessão personalizada é especifica para o método findById
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
