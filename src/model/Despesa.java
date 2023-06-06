package model;



public abstract class Despesa {
    private String nome;
    private double valor;

    public Despesa(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
    
    public abstract String getTipo();
}
