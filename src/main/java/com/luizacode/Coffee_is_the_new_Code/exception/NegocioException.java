package com.luizacode.Coffee_is_the_new_Code.exception;

public class NegocioException extends Exception{
    private static final long serialVersionUID = 1L;

    public NegocioException(String mensagem) {
        super(mensagem);
    }
}
