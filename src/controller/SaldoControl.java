package controller;

import model.Saldo;

public class SaldoControl extends Saldo{
    
    public void addSaldo(double newSaldo){
        valorSaldo = newSaldo + getValorSaldo();
    }

    public void subSaldo(double sub){
        valorSaldo =  getValorSaldo() - sub ;

        System.out.printf("Seu saldo atual é R$ %.2f", valorSaldo);
    }


    public String mostraSaldo(){

        return"Seu saldo é de R$ "+getValorSaldo();
    }
}
