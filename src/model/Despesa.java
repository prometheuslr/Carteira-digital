package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Criando umaa classe abstrata chamada "Despesa" que
possui nome, valor e data
*/
public abstract class Despesa {
    private String nome;
    private double valor;
    private String data;
    
    // Usando as bibliotecas java.text.DateFormat e java.util.Date para definir a data atual
    static String getDataHoraAtual() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dataHoraAtual = new Date();
        return dateFormat.format(dataHoraAtual);
    }
    
    // Definindo os atributos "nome" e "valor" da classe "Despesa"
    public Despesa(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
