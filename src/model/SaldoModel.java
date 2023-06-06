package model;



public class SaldoModel {
    private double saldo;

    public SaldoModel() {
        this.saldo = 0.0;
    }

    public void addSaldo(double valor) {
        saldo += valor;
    }

    public void subtractSaldo(double valor) {
        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }
}

