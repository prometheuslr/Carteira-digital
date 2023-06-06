package model;

public class Debito extends Despesa {
    // Construtor da classe que recebe o nome e valor do débito
    public Debito(String nome, double valor) {
        super(nome, valor);
    }

    @Override
    // Sobrescrevendo o método getTipo() da classe pai
    public String getTipo() {
        return "Débito";
    }
}
