package model;

//classe "Salario" que possui dois atributos "valoSalari"o e "diaPagamento"
public class Salario {
    double valoSalario;
    int diaPagamento;

    //getter de diaPagamento
    public int getDiaPagamento() {
        return diaPagamento;
    }
    
    //setter de diaPagamento
    public void setDiaPagamento(int diaPagamento) {
        this.diaPagamento = diaPagamento;
    }
    //getter de valoSalario
    public double getValoSalario() {
        return valoSalario;
    }
    //setter de valoSalario
    public double setValoSalario(double valoSalario) {
        this.valoSalario = valoSalario;
        return this.valoSalario;
    }



    



}
