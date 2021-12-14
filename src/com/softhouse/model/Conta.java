package com.softhouse.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {

    protected static double SALDO_INICIAL = 0;

    private int numero;
    private Tipo tipo;
    private double saldo;
    private List<Movimento> movimentacao = new ArrayList<>();

    public Conta(int numero, Tipo tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = 0;           // abriu conta, saldo zero!
    }

    public void depositar(double valor) {
        incorporarValorAoSaldo(Operacao.DEPOSITO, valor);
    }

    public void sacar(double valor) {
        if (valor > 0.0) {
            registrarMovimento(Operacao.SAQUE, valor);
            saldo -= valor;
        }
    }

    // acessível à classe filha
    protected void incorporarValorAoSaldo(Operacao operacao, double valor) {
        if (valor > 0.0 && operacao != null) {
            registrarMovimento(operacao, valor);
            saldo += valor;
        }
    }

    public void extrato() {

        int tamTraco = 37 - tipo.getDescricao().trim().length();

        System.out.println("\n" + "=".repeat(tamTraco) + " Extrato " + tipo.getDescricao());
        System.out.println("data---- Op- Valor----");

        for (Movimento m: movimentacao)
            System.out.println(m + " ");

        System.out.printf("       Saldo %8.2f=%n", saldo);

        if (saldo < 0) {
            System.out.println("-".repeat(46));
            System.out.println("** USANDO LIMITE CHEQUE ESPECIAL **");
        }

        System.out.println("-".repeat(46) + "\n");

    }

    public int getNumero() {return numero;}
    public Tipo getTipo() {return tipo;}
    public double getSaldo() {return saldo;}

    private void registrarMovimento(Operacao operacao, double valor) {
        movimentacao.add(
                new Movimento(LocalDateTime.now(), operacao, valor)
        );
    }

}
