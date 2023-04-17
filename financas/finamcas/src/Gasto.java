public class Gasto extends Saldo{
    String nomeGasto;
    float valorGasto;



    void mostraGasto(){
        System.out.format("%s|Valor: %.2f\n", nomeGasto, valorGasto);
    }


}
