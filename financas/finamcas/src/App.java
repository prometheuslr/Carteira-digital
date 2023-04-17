public class App {
    public static void main(String[] args) throws Exception {
        Saldo saldo01 = new Saldo();
            saldo01.valorSaldo = 1000;
        saldo01.mostraSaldo();

        Gasto gasto1 = new Gasto();
            gasto1.nomeGasto = "conta celular";
            gasto1.valorGasto = 50f;

        gasto1.mostraGasto();

        saldo01.valorSaldo = 1000 - gasto1.valorGasto ;
        saldo01.mostraSaldo();

    }
}
