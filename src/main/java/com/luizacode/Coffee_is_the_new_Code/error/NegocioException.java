package com.luizacode.Coffee_is_the_new_Code.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class NegocioException extends RuntimeException{
    public NegocioException(String mensagem) {
        super(mensagem);
    }
}
