package model;

// Classe "Salario" que possui dois atributos "valoSalari"o e "diaPagamento"
public class Salario {
    double valoSalario;
    int diaPagamento;

    // Getter de diaPagamento
    public int getDiaPagamento() {
        return diaPagamento;
    }
    
    // Setter de diaPagamento
    public void setDiaPagamento(int diaPagamento) {
        this.diaPagamento = diaPagamento;
    }
    // Getter de valoSalario
    public double getValoSalario() {
        return valoSalario;
    }
    // Setter de valoSalario
    public double setValoSalario(double valoSalario) {
        this.valoSalario = valoSalario;
        return this.valoSalario;
    }



    



}
