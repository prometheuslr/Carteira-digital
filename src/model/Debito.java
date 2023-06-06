package model;

public class Debito extends Despesa {
    public Debito(String nome, double valor) {
        super(nome, valor);
    }

    @Override
    public String getTipo() {
        return "Débito";
    }
}