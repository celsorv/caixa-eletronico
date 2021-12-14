package com.softhouse.model;

import com.softhouse.exception.SaldoInsuficienteException;

public class Poupanca extends Conta {

    public Poupanca(int numero) {

        // chama construtor da classe pai
        super(numero, Tipo.POUPANCA);

    }

    // sobreposição de método para impor condição para o saque
    public void sacar(double valor) throws SaldoInsuficienteException {

        if (valor > getSaldo())
            throw new SaldoInsuficienteException();  // lança exceção

        super.sacar(valor);

    }

    public void aplicarRendimentoPeriodo(double percentual) {

        double rendimento = getSaldo() * percentual / 100;
        incorporarValorAoSaldo(Operacao.RENDIMENTO, rendimento);

    }

}
