package view;

import java.util.Scanner;

import model.Carteira;


public class CarteiraView {
    private Scanner scanner;

    public CarteiraView() {
        this.scanner = new Scanner(System.in);
    }

    public int exibirMenu() {
        System.out.println("----- Carteira Virtual -----");
        System.out.println("1. Criar uma nova carteira");
        System.out.println("2. Ler uma carteira existente");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public String lerNomeCarteira() {
        System.out.print("Digite o nome da carteira: ");
        return scanner.next();
    }

    public void exibirCarteira(Carteira carteira) {
        System.out.println("----- Detalhes da Carteira -----");
        System.out.println("Nome: " + carteira.getNome());
        System.out.println("Saldo: R$" + carteira.getSaldo());
    }

    public double lerValor() {
        System.out.print("Digite o valor: ");
        String valorString = scanner.next();
    valorString = valorString.replace(",", ".");
    double valor = Double.parseDouble(valorString);
    return valor;
    }

    public String lerNomeArquivo() {
        System.out.print("Digite o nome do arquivo: ");
        return scanner.next();
    }

    public int exibirMenuCarteira() {
        System.out.println("----- Menu da Carteira -----");
        System.out.println("1. Adicionar valor");
        System.out.println("2. Adicionar despesa");
        System.out.println("3. Conferir saldo");
        System.out.println("4. Conferir extrato");
        System.out.println("0. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public String lerNomeDespesa() {
        System.out.print("Digite o nome da despesa: ");
        return scanner.next();
    }

    public void exibirDespesa(String despesa) {
        System.out.println("Despesa registrada: " + despesa);
    }

    public void exibirValor(String valor) {
        System.out.println("Valor registrado: " + valor);
    }

    public int exibirMenuOpcoes() {
    System.out.print("Escolha uma opção: ");
    return scanner.nextInt();
  } 
}

