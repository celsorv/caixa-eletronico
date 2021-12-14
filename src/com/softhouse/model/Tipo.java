package com.softhouse.model;

public enum Tipo {

    CORRENTE_FREE("Conta Plus", true),
    CORRENTE_PLUS("Conta Free", true),
    POUPANCA("Super Poup", false);

    private String descricao;
    private boolean contaCorrente;

    Tipo(String descricao, boolean contaCorrente) {
        this.descricao = descricao;
        this.contaCorrente = contaCorrente;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isContaCorrente() {
        return contaCorrente;
    }
}