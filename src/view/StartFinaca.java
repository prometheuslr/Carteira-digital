package view;

import java.util.Scanner;

import javax.swing.JOptionPane;

import controller.Extrato;
import controller.SaldoControl;
import model.Debito;
import model.Saldo;

public class StartFinaca {
    public static void main(String[] args) {
            int opcao ;    
            int dia;
            double valSalario;
            Saldo saldo = new Saldo();
            Scanner ler = new Scanner(System.in);
            String opc="sim";
            SaldoControl saldContro = new SaldoControl();
            Extrato ext = new Extrato();
        
            while(!opc.equals("nao")){

                
                System.out.println("---------------------------------------");
                System.out.println("Menu(Digite o numero para ter acesso)");
                System.out.println("---------------------------------------");
    
                System.out.println("1- Definir Salario");
                System.out.println("2- Add Extra");
                System.out.println("3- Conferir Saldo");
                System.out.println("4- Add Despesa");
                opcao =  ler.nextInt();
    
                switch (opcao) {
                    case 1:
                        System.out.println("Valor do salario:");
                        valSalario = ler.nextDouble();
                        double a = saldo.setValoSalario(valSalario);
                        saldContro.addSaldo(a);
                        System.out.println("Dia do pagamento:");    
                        dia = ler.nextInt();
                        saldo.setDiaPagamento(dia);
                         ext.salvarAlteracao(saldContro.getValorSaldo());
                        break;
    
                    case 2:
                        System.out.println("Digite o valor que deseja add ao eu saldo:");
                        saldContro.addSaldo(ler.nextDouble());
                        ext.salvarAlteracao(saldContro.getValorSaldo());

                        break;
                        
                    case 3:
                    saldContro.mostraSaldo();
                        break;
                        
                    case 4:
                        
                        break;
                        
                        default:
                        break;
                    }
                    System.out.println("Deseja voltar para o menu?(sim/nao)");
                    opc= ler.next();
            }
            

            
    }
}
