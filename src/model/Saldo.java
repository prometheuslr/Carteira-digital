package model;

public class Saldo {
    private double valorSaldo;

    public double getValorSaldo() {
        return valorSaldo;
    }

    public void setValorSaldo(double valorSaldo) {
        this.valorSaldo = valorSaldo;
    }

    public void addSaldo(double newSaldo){
        valorSaldo = newSaldo + getValorSaldo();
    }

    public void subSaldo(double sub){
        valorSaldo =  getValorSaldo() - sub ;

        System.out.printf("Seu saldo atual é R$ %.2f", valorSaldo);
    }


}
    
