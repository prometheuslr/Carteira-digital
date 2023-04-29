public class Gasto {
    String nomeGasto;
   double valorGasto;


    public Gasto(String nomeGasto, double valorGasto ){
        this.nomeGasto = nomeGasto;
        this.valorGasto = valorGasto;
    }

    public double getValorGasto() {
        return valorGasto;
    }
    public void setValorGasto(float valorGasto) {
        this.valorGasto = valorGasto;
    }

    public String getNomeGasto() {
        return nomeGasto;
    }

    public void setNomeGasto(String nomeGasto) {
        this.nomeGasto = nomeGasto;
    }
    void mostraGasto(){
        System.out.format("%s|Valor: %.2f\n", nomeGasto, valorGasto);
    }


}
