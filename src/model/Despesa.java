package model;


//classe "Despesa" declarada com o modificador "public" e com dois atributos "nome" e "valor" 
public abstract class Despesa {
    private String nome;
    private double valor;

     // Construtor da classe que recebe o nome e valor da despesa
    public Despesa(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

     // Construtor da classe que recebe o nome e valor da despesa
    public String getNome() {
        return nome;
    }

    // Getter para obter o valor da despesa
    public double getValor() {
        return valor;
    }
    
    // Método abstrato para obter o tipo da despesa
    public abstract String getTipo();
}
