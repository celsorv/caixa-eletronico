package com.softhouse.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimento {

    private static final DateTimeFormatter formatterData
            = DateTimeFormatter.ofPattern("dd/MM/yy");

    private LocalDateTime dataHora;
    private Operacao operacao;
    private double valor;

    public Movimento(LocalDateTime dataHora, Operacao operacao, double valor) {
        this.dataHora = dataHora;
        this.operacao = operacao;
        this.valor    = valor;
    }

    public String toString() {
        return String.format("%s %s %8.2f%s",
                    formatterData.format(dataHora),
                    operacao.getSigla(),
                    valor,
                    Operacao.SAQUE.equals(operacao) ? "-" : "+"
                );
    }

    public LocalDateTime getDataHora() {return dataHora;}
    public Operacao getOperacao() {return operacao;}
    public double getValor() {return valor;}

}