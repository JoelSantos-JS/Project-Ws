package com.br.joel.Project.Ws.exceptions;

public class BusinessException extends  RuntimeException{

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }
}
