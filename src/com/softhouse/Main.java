package com.softhouse;

import com.softhouse.model.Conta;
import com.softhouse.model.Corrente;
import com.softhouse.model.Poupanca;
import com.softhouse.model.Tipo;

import java.util.Arrays;

public class Main {

    // propriedades da classe Main

    static final double LIMITE_CONTA = 1000;

    static final int I_CONTA_PLUS = 0;
    static final int I_CONTA_FREE = 1;
    static final int I_SUPER_POUP = 2;

    public static void main(String[] args) {

        try {

            System.out.println(); // salta linha

            Conta[] contas = new Conta[3];   // array com as 3 contas

            contas[I_CONTA_PLUS] = new Corrente(1231, Tipo.CORRENTE_PLUS, LIMITE_CONTA);
            contas[I_CONTA_FREE] = new Corrente(1232);
            contas[I_SUPER_POUP] = new Poupanca(5001);

            // fazendo depósito inicial
            contas[I_CONTA_FREE].depositar(100);
            contas[I_CONTA_PLUS].depositar(300);
            contas[I_SUPER_POUP].depositar(2000);

            contas[I_SUPER_POUP].sacar(1000);
            contas[I_CONTA_FREE].sacar(100);
            contas[I_CONTA_PLUS].sacar(1200);

            ((Poupanca) contas[I_SUPER_POUP]).aplicarRendimentoPeriodo(0.6);

            // impressão dos extratos
            Arrays.stream(contas).forEach(Conta::extrato);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        System.out.println(); // salta linha

    }

    private static void imprimeExtrato(Conta[] contas, String titulo) {

        System.out.println("\n" + "-".repeat(30) + " " + titulo);

        for (Conta conta : contas)
            System.out.println(conta);

        System.out.println("-".repeat(30) + "\n");

    }


}
