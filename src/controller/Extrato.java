package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Saldo;

public class Extrato  {
    
   //método de obter a última linha onde ira retornar a última linha
    public static String obterUltimaLinha(String arquivo) {
        String lastLine = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return lastLine;
    }
    
    //método para obter o valor do saldo a partir de uma linha do extrato
    private double obterValorSaldo(String linha) {
        int index = linha.indexOf("Saldo:R$ ");
        if (index != -1) {
            String valorSaldoStr = linha.substring(index + 9).trim();
            int endIndex = valorSaldoStr.indexOf(" ");
            if (endIndex != -1) {
                valorSaldoStr = valorSaldoStr.substring(0, endIndex);
            }
            return Double.parseDouble(valorSaldoStr);
        }
        return 0.0;
    }

    //método para obter a data e hora atual formatada como string
    static final String FILENAME = "extrato.txt";
     static String getDataHoraAtual() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dataHoraAtual = new Date();
        return dateFormat.format(dataHoraAtual);
    }
    
    //método para salvar uma alteração no saldo no arquivo de extrato 
    public static void salvarAlteracao(double saldoAnterior, double novoSaldo) {
        double saldoTotal = saldoAnterior + novoSaldo;
        try {
            if (!Files.exists(Paths.get(FILENAME))) {
                Files.createFile(Paths.get(FILENAME));
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true));
            writer.append("Saldo:R$ " + saldoTotal + " - " + getDataHoraAtual());
            writer.newLine();
            writer.close();

            System.out.println("Alteração salva com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar a alteração: " + e.getMessage());
        }
    }

    //método para obter o saldo atual a partir do arquivo de extrato
    public double obterSaldoAtual(String arquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String lastLine = null;
            String line;
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }
            if (lastLine != null) {
                return obterValorSaldo(lastLine);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return 0.0; //retorna 0 se não houver saldo registrado no extrato
    }
}
