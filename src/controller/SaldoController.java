package controller;

// Importando as classes necessárias
import model.SaldoModel;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class SaldoController {
    // Atributo para armazenar o modelo de saldo
    private static SaldoModel saldoModel;

    // Construtor padrão da classe
    public SaldoController() {
        this.saldoModel = new SaldoModel();
        initSaldoFromExtrato();
    }

    // Construtor sobrecarregado para definir um saldo inicial
    public SaldoController(double saldoInicial) {
        this.saldoModel = new SaldoModel();
        this.saldoModel.addSaldo(saldoInicial);
    }

    // Método para adicionar saldo
    public void addSaldo(double valor) {
        // Verificando se o valor informado é negativo
        if (valor < 0) {
            System.out.println("O valor informado é negativo. Por favor, informe um valor válido ou volte para o menu.");
            return;
        }

        double saldoAtual = saldoModel.getSaldo();
        double novoSaldo = saldoAtual + valor;

        // Verificando se o novo saldo seria menor que zero
        if (novoSaldo < 0) {
            System.out.println("O novo saldo seria menor que zero. Por favor, informe um valor válido ou volte para o menu.");
            return;
        }

        saldoModel.addSaldo(valor);
        registrarMovimentacao("Adicionado saldo: +" + valor);
    }

    // Método para adicionar saldo a partir da entrada do usuário
    public void addSaldoFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Informe o valor a ser adicionado (ou digite 0 para voltar para o menu): ");
            double valor = scanner.nextDouble();

            if (valor < 0) {
                System.out.println("O valor informado é negativo. Por favor, informe um valor positivo ou volte para o menu.");
            } else if (valor > 0) {
                double saldoAtual = saldoModel.getSaldo();
                double novoSaldo = saldoAtual + valor;

                if (novoSaldo < 0) {
                    System.out.println("O novo saldo seria menor que zero. Por favor, informe um valor válido ou volte para o menu.");
                } else {
                    saldoModel.addSaldo(valor);
                    registrarMovimentacao("Adicionado saldo: +" + valor);
                    System.out.println("Saldo adicionado com sucesso.");
                    break;
                }
            } else {
                break;
            }
        }
    }

    // Método para subtrair saldo
    public static void subtractSaldo(double valor) {
        saldoModel.subtractSaldo(valor);
        registrarMovimentacao("Despesa registrada: -" + valor);
    }

    // Método para obter o saldo atual
    public static double getSaldo() {
        return saldoModel.getSaldo();
    }

    // Método privado para registrar uma movimentação no extrato
    private static void registrarMovimentacao(String movimentacao) {
        try {
            // Criando um FileWriter para escrever no arquivo de extrato, com o segundo parâmetro "true" para permitir a escrita no final do arquivo
            FileWriter writer = new FileWriter("extrato.txt", true);
            
            // Obtendo a data e hora atuais
            LocalDateTime dataHoraAtual = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataHoraFormatada = dataHoraAtual.format(formatter);
            
            // Obtendo o saldo atual
            double saldoAtual = SaldoController.getSaldo();
            
            // Formatando a movimentação completa
            String movimentacaoCompleta = dataHoraFormatada + " - " + movimentacao;
            
            // Formatando o registro completo do extrato
            String extrato = movimentacaoCompleta + " - Saldo atual: " + saldoAtual;
            
            // Escrevendo o registro no arquivo de extrato
            writer.write(extrato + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de extrato: " + e.getMessage());
        }
    }

    // Método privado para inicializar o saldo a partir do arquivo de extrato
    private static void initSaldoFromExtrato() {
        try {
            // Lendo todas as linhas do arquivo de extrato
            List<String> lines = Files.readAllLines(Paths.get("extrato.txt"));
            
            // Verificando se o arquivo não está vazio
            if (!lines.isEmpty()) {
                // Obtendo a última linha do arquivo
                String lastLine = lines.get(lines.size() - 1);
                
                // Dividindo a linha em partes
                String[] parts = lastLine.split(" - Saldo atual: ");
                
                // Obtendo o saldo inicial a partir da última linha do arquivo
                double saldoInicial = Double.parseDouble(parts[1]);
                
                // Adicionando o saldo inicial ao modelo de saldo
                saldoModel.addSaldo(saldoInicial);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de extrato: " + e.getMessage());
        }
    }

    // Método para exibir o saldo atual
    public void mostraSaldo() {
        double saldoAtual = getSaldo();
        System.out.println("Seu saldo atual é: " + saldoAtual);
    }

    public static void debitarSaldo(double valor) {
    }
}
