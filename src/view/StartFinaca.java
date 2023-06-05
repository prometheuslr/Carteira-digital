package view;
import controller.DebitoController;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import controller.Extrato;
import controller.SaldoControl;
import model.Debito;
import model.Saldo;


    public class StartFinaca {
        public static void main(String[] args) {
            int opcao;
            int dia;
            double valSalario;
            Scanner ler = new Scanner(System.in);
            String opc = "sim";
            SaldoControl saldContro = new SaldoControl();
            Extrato ext = new Extrato();
            Saldo saldo = new Saldo(ext.obterSaldoAtual("extrato.txt"));
    
            if (Files.exists(Paths.get("extrato.txt"))) {
                saldo.setValorSaldo(ext.obterSaldoAtual("extrato.txt"));
            }
    
            while (!opc.equals("nao")) {
    
                System.out.println("---------------------------------------");
                System.out.println("Menu(Digite o numero para ter acesso)");
                System.out.println("---------------------------------------");
    
                System.out.println("1- Definir Salario");
                System.out.println("2- Add Extra");
                System.out.println("3- Conferir Saldo");
                System.out.println("4- Add Despesa");
                System.out.println("5- Conferir extrato");
                opcao = ler.nextInt();
    
                switch (opcao) {
                    case 1:
                        System.out.println("Valor do salario:");
                        valSalario = ler.nextDouble();
                        double a = saldo.setValoSalario(valSalario);
                        saldContro.addSaldo(a);
                        System.out.println("Dia do pagamento:");
                        dia = ler.nextInt();
                        saldo.setDiaPagamento(dia);
                        ext.salvarAlteracao(saldo.getValorSaldo(), saldContro.getValorSaldo());
                        break;
    
                    case 2:
                        System.out.println("Digite o valor que deseja add ao eu saldo:");
                        saldContro.addSaldo(ler.nextDouble());
                        ext.salvarAlteracao(saldo.getValorSaldo(), saldContro.getValorSaldo());
                        break;
    
                    case 3:
                        saldContro.mostraSaldo();
                        break;
    
                    case 4:
                    System.out.println("Qual é o nome da despesa:");
                    String nomeDespesa = ler.next();
                    System.out.println("Qual é o valor da despesa:");
                    double valorDespesa = ler.nextDouble();
                    DebitoController.registrarDebito(valorDespesa,  saldContro.getValorSaldo());
                    break;
    
                    case 5:
                        break;
    
                    default:
                        break;
                }
                System.out.println("Deseja voltar para o menu?(sim/nao)");
                opc = ler.next();
                
            }
        }
    }

