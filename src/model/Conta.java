package model;

public abstract class Conta {
    protected String nome;
    protected double saldo;

    public Conta(String nome) {
        this.nome = nome;
        this.saldo = 0.0;
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Métodos abstratos

    public abstract void adicionarValor(double valor);

    public abstract void adicionarDespesa(double despesa);

    public abstract void conferirSaldo();

    public abstract void conferirExtrato();
}
