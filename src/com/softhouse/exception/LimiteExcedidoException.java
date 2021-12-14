package com.softhouse.exception;

public class LimiteExcedidoException extends RuntimeException {

    @Override
    public String getMessage(){
        return "Saque excede o limite disponível";
    }

}