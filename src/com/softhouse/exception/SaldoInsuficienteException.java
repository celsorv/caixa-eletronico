package com.softhouse.exception;

public class SaldoInsuficienteException extends RuntimeException {

    @Override
    public String getMessage(){
        return "Não há saldo insuficiente para o saque";
    }

}
