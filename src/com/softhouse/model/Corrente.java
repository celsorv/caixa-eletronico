package com.softhouse.model;

import com.softhouse.exception.LimiteExcedidoException;

public class Corrente extends Conta {

    private double limite;  // propriedade específica dessa classe

    public Corrente(int numero, Tipo tipo, double limite) {

        // chama construtor da classe pai
        super(numero, tipo);

        this.limite = limite;            // atribui valor à propriedade

    }

    // sobrecarga de construtor - limite zero
    public Corrente(int numero, Tipo tipo) {
        this(numero, tipo, 0);
    }

    // sobrecarga de construtor - conta free e limite zero
    public Corrente(int numero) {
        this(numero, Tipo.CORRENTE_FREE, 0);
    }

    // sobreposição de método para impor condição para o saque
    public void sacar(double valor) throws LimiteExcedidoException {

        double valorSaqueMaximo = getSaldo() + getLimite();

        if (valor > valorSaqueMaximo)
            throw new LimiteExcedidoException();  // lança exceção

        super.sacar(valor);

    }

    public double getLimite() {return limite;}
    public void setLimite(double limite) {this.limite = limite;}

}
