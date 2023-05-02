
import javax.sound.sampled.AudioFileFormat.Type;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        
        String saldoSt = JOptionPane.showInputDialog("Defina o seu saldo:");
        
        double saldoDouble = Double.parseDouble(saldoSt);
        
        Saldo saldo01 = new Saldo(saldoDouble);
            
        int continuar = 0;
        while(continuar == 0){

            String nomeGasto = JOptionPane.showInputDialog("Nome do Gasto:");
            String valorGasto = JOptionPane.showInputDialog("Valor do Gasto:");
    
            double valorGastoDouble = Double.parseDouble(valorGasto);
            Gasto gasto01 = new Gasto(nomeGasto, valorGastoDouble);
               
               
            saldo01.valorSaldo = saldo01.valorSaldo - gasto01.valorGasto ;
                
            String saldoGastoSt = String.valueOf(saldo01.valorSaldo);
            JOptionPane.showMessageDialog(null,"O seu saldo atual é : "+ saldoGastoSt);
    
            continuar = JOptionPane.showConfirmDialog(null, "Deseja continuar");
        }
    }
}
