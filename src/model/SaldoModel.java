package model;



public class SaldoModel {
    private double saldo;

    // Construtor da classe que define o saldo inicial como 0.0
    public SaldoModel() {
        this.saldo = 0.0;
    }

    // Método para adicionar um valor ao saldo
    public void addSaldo(double valor) {
        saldo += valor;
    }

    // Método para subtrair um valor do saldo
    public void subtractSaldo(double valor) {
        saldo -= valor;
    }
 
    // Método para obter o valor atual do saldo
    public double getSaldo() {
        return saldo;
    }
}

