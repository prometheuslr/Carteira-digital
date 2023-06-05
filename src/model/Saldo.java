package model;

// Classe "Saldo" que vai herdar as caracteristicas da classe "Salario"
public class Saldo extends Salario{
    
     /* 
    Modificador de acesso "protected" que torna o membro acessível 
    às classes do mesmo pacote ou através de herança
    */  
    protected double valorSaldo;
    
    // Definindo o valor inicial do saldo no caso "0.0"
    public Saldo() {
        this.valorSaldo = 0.0;
    }

    public Saldo(double valorSaldo) {
        this.valorSaldo = valorSaldo;
    }
    public double getValorSaldo() {
        return valorSaldo;
    }

    public void setValorSaldo(double valorSaldo) {
        this.valorSaldo = valorSaldo;
    }
    
    // Adiciona um valor ao saldo atual
    public void addSaldo(double newSaldo){
        
    }
    
    // Subtrai um valor do saldo atual
    public void subSaldo(double sub){
        
    }


  


}
    
