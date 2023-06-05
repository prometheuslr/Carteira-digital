package controller;

import model.Saldo;

public class SaldoControl extends Saldo{
    
    // Adiciona um valor ao saldo atual
    public void addSaldo(double newSaldo) {
        valorSaldo += newSaldo;
    }
    
     // Subtraindo um valor ao saldo atual
    public void subSaldo(double sub){
        valorSaldo =  getValorSaldo() - sub ;

        System.out.printf("Seu saldo atual é R$ %.2f", valorSaldo);
    }

    // Retornando o valor do saldo mais a frase "Seu saldo é de R$"
    public String mostraSaldo(){

        return"Seu saldo é de R$ "+getValorSaldo();
    }
    
}
