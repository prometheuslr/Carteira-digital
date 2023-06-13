package controller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Carteira;
import view.CarteiraView;

public class CarteiraController {
    private Carteira carteira;
    private CarteiraView view;
    private List<String> extrato;

    public CarteiraController(Carteira carteira, CarteiraView view) {
        this.carteira = carteira;
        this.view = view;
        this.extrato = new ArrayList<>();
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = view.exibirMenu();
            switch (opcao) {
                case 1:
                    criarCarteira();
                    break;
                case 2:
                    lerCarteiraExistente();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private void criarCarteira() {
        String nome = view.lerNomeCarteira();
        carteira.setNome(nome);
        view.exibirCarteira(carteira);

        try (PrintWriter writer = new PrintWriter(new FileWriter(nome + ".txt"))) {
            writer.println("Nome: " + carteira.getNome());
            writer.println("Saldo: R$" + carteira.getSaldo());
            System.out.println("Arquivo criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
        }

        menuCarteira();
    }

    private void lerCarteiraExistente() {
        String nomeArquivo = view.lerNomeArquivo();

        try (Scanner scanner = new Scanner(new File(nomeArquivo + ".txt"))) {
            String nome = scanner.nextLine().replace("Nome: ", "");
            String saldoStr = scanner.nextLine().replace("Saldo: R$", "");
            double saldo = Double.parseDouble(saldoStr);

            carteira.setNome(nome);
            carteira.setSaldo(saldo);

            view.exibirCarteira(carteira);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (linha.startsWith("----- Extrato -----")) {
                    break;
                }
            }

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (linha.startsWith("-------------------")) {
                    break;
                }
                extrato.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        menuCarteira();
    }

    private void menuCarteira() {
        int opcao;
        do {
            opcao = view.exibirMenuCarteira();
            switch (opcao) {
                case 1:
                    adicionarValor();
                    break;
                case 2:
                    adicionarDespesa();
                    break;
                case 3:
                    conferirSaldo();
                    break;
                case 4:
                    conferirExtrato();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private void adicionarValor() {
        double valor = view.lerValor();
        carteira.setSaldo(carteira.getSaldo() + valor);
        System.out.println("Valor adicionado com sucesso!");

        String dataHora = getDataHoraAtual();
        String registro = dataHora + " - Valor adicionado: R$" + valor;
        extrato.add(registro);
        view.exibirValor(registro);

        atualizarArquivo();
    }

    private void adicionarDespesa() {
    String nomeDespesa = view.lerNomeDespesa();
    double valor = view.lerValor();

    if (valor > carteira.getSaldo()) {
        System.out.println("Saldo insuficiente! Opções:");
        System.out.println("1. Digitar outro valor");
        System.out.println("2. Voltar ao menu");

        int opcao = view.exibirMenuOpcoes();
        switch (opcao) {
            case 1:
                adicionarDespesa(); // Chama o método novamente para digitar outro valor
                break;
            case 2:
                break; // Volta ao menu principal
            default:
                System.out.println("Opção inválida! Voltando ao menu principal...");
                break;
        }
    } else {
        carteira.setSaldo(carteira.getSaldo() - valor);
        System.out.println("Despesa adicionada com sucesso!");

        String dataHora = getDataHoraAtual();
        String registro = dataHora + " - Despesa: " + nomeDespesa + ", Valor: R$" + valor;
        extrato.add(registro);
        view.exibirDespesa(registro);

        atualizarArquivo();
    }
}

    private String getDataHoraAtual() {
        Date dataHoraAtual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formato.format(dataHoraAtual);
    }

    private void conferirSaldo() {
        view.exibirCarteira(carteira);
    }

    private void conferirExtrato() {
        System.out.println("----- Extrato -----");
        for (String registro : extrato) {
            System.out.println(registro);
        }
        System.out.println("-------------------");
    }

    private void atualizarArquivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(carteira.getNome() + ".txt"))) {
            writer.println("Nome: " + carteira.getNome());
            writer.println("Saldo: R$" + carteira.getSaldo());
            writer.println("----- Extrato -----");
            for (String registro : extrato) {
                writer.println(registro);
            }
            writer.println("-------------------");
            System.out.println("Arquivo atualizado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
        }
    }
}



