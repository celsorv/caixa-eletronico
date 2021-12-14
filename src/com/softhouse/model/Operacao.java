package com.softhouse.model;

public enum Operacao {

    RENDIMENTO("Rnd"),
    DEPOSITO("Dep"),
    SAQUE("Saq");

    private String sigla;

    Operacao(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }

}