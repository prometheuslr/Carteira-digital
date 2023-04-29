public class Saldo{
    double valorSaldo;


public Saldo(double valorSaldo){
    this.valorSaldo = valorSaldo;
}

public double getValorSaldo() {
        return valorSaldo;
    }


    public void setValorSaldo(float valorSaldo) {
        this.valorSaldo = valorSaldo;
    }


void mostraSaldo(){
    System.out.format("O seu saldo é: R$ %.2f\n", valorSaldo);
}
}