package io.github.t14g.clientes.rest.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {
    
    //Para retornar os erros
    @Getter
    private List<String> errors;

    //Construtor
    public ApiErrors(List<String> errors) {
        this.errors = errors;
    }

    public ApiErrors(String message){
        this.errors = Arrays.asList();
    }


}
