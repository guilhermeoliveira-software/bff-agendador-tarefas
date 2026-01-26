package com.costadev.bff_agendadortarefas.infrastructure.exceptions;

public class IllegalArgumentException extends RuntimeException{

    public IllegalArgumentException(String mensagem){
        super(mensagem);
    }

    public IllegalArgumentException(String mensagem, Throwable cause){
        super(mensagem, cause);
    }

}
