package view;

import java.util.Scanner;

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

        
            while(!opc.equals("nao")){

                System.out.println("---------------------------------------");
                System.out.println("Menu(Digite o numero para ter acesso)");
                System.out.println("---------------------------------------");
    
                System.out.println("1- Add Salario");
                System.out.println("2- Add Extra");
                System.out.println("3- Conferi Saldo");
                System.out.println("4- Add Dispeza");
                opcao =  ler.nextInt();
    
                switch (opcao) {
                    case 1:
                        System.out.println("Valor do salario:");
                        valSalario = ler.nextDouble();
                        saldo.setValoSalario(valSalario);
                        System.out.println("Dia do pagamento:");    
                        dia = ler.nextInt();
                        saldo.setDiaPagamento(dia);
                        
                        break;
    
                    case 2:
                        System.out.println("Digite o valor que deseja add ao eu saldo:");
                        saldo.addSaldo(ler.nextDouble());

                        break;
                        
                    case 3:
                        System.out.println(saldo.mostraSaldo());
                        break;
                        
                    case 4:
                        
                        break;
                        
                        default:
                        break;
                    }
                    System.out.println("Deseja voltar para o menu?");
                    opc= ler.next();
            }
            

            
    }
}
