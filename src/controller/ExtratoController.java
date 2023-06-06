package controller; 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExtratoController {
    // Método responsável por exibir o extrato
    public static void exibirExtrato() {
        // Criando uma instância do objeto File para representar o arquivo de extrato
        File extratoFile = new File("extrato.txt");
        
        // Verificando se o arquivo não existe ou está vazio
        if (!extratoFile.exists() || extratoFile.length() == 0) {
            System.out.println("Nenhum registro de extrato encontrado.");
            return;
        }

        try {
            // Criando um BufferedReader para ler o arquivo de extrato
            BufferedReader reader = new BufferedReader(new FileReader(extratoFile));
            String line;
            System.out.println("===== Extrato =====");
            
            // Lendo cada linha do arquivo e exibindo no console
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            System.out.println("===================");
            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o extrato.");
            e.printStackTrace();
        }
    }

    // Método responsável por adicionar um registro no extrato
    public static void adicionarRegistro(String nome, double valor) {
        try {
            // Criando um FileWriter para escrever no arquivo de extrato, com o segundo parâmetro "true" para permitir a escrita no final do arquivo
            FileWriter fw = new FileWriter("extrato.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            
            // Escrevendo a linha no formato "nome,valor" no arquivo de extrato
            pw.println(nome + "," + valor);
            
            // Fechando o PrintWriter e exibindo uma mensagem de sucesso
            pw.close();
            System.out.println("Registro adicionado ao extrato.");
        } catch (IOException e) {
            System.out.println("Erro ao adicionar registro ao extrato: " + e.getMessage());
        }
    }
}