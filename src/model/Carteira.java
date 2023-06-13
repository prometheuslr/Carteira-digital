package model;

public class Carteira extends Conta {
    public Carteira(String nome) {
        super(nome);
    }

    @Override
    public void adicionarValor(double valor) {
        saldo += valor;
    }

    @Override
    public void adicionarDespesa(double despesa) {
        saldo -= despesa;
    }

    @Override
    public void conferirSaldo() {
        System.out.println("Saldo da Carteira: R$" + saldo);
    }

    @Override
    public void conferirExtrato() {
        System.out.println("Extrato da Carteira:");
        System.out.println("Nome: " + nome);
        System.out.println("Saldo: R$" + saldo);
    }
}
