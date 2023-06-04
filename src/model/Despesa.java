package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Despesa {
    private String nome;
    private double valor;
    private String data;
    
    static String getDataHoraAtual() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dataHoraAtual = new Date();
        return dateFormat.format(dataHoraAtual);
    }

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
