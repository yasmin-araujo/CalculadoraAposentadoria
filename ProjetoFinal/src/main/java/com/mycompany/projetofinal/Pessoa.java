/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetofinal;

import java.util.Calendar;

/**
 *
 * @author YasminAraujo
 */

public class Pessoa {
    private Calendar dataNascimento;
    private int tempoContribuicaoAno;
    private int tempoContribuicaoMes;
    private int genero; 
    private int categoria;
    private Calendar dataAtual = Calendar.getInstance();
    
    public Pessoa(int dia, int mes, int ano, int tempoContribuicaoAno, int tempoContribuicaoMes, int genero, int categoria)
    {
        dataNascimento = Calendar.getInstance();
        dataNascimento.set(Calendar.YEAR, ano);
        dataNascimento.set(Calendar.MONTH, mes);
        dataNascimento.set(Calendar.DAY_OF_MONTH, dia);
        this.tempoContribuicaoAno = tempoContribuicaoAno;
        this.tempoContribuicaoMes = tempoContribuicaoMes;
        this.genero = genero;
        this.categoria = categoria;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public void setTempoContribuicaoAno(int tempoContribuicaoAno) {
        this.tempoContribuicaoAno = tempoContribuicaoAno;
    }

    public void setTempoContribuicaoMes(int tempoContribuicaoMes) {
        this.tempoContribuicaoMes = tempoContribuicaoMes;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public int getGenero() {
        return genero;
    }

    public int getTempoContribuicaoAno() {
        return tempoContribuicaoAno;
    }

    public int getTempoContribuicaoMes() {
        return tempoContribuicaoMes;
    }

    public int getCategoria() {
        return categoria;
    }
    
    public int getIdade() {
        int idade = dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
        if(dataAtual.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) idade--;
        else if(dataAtual.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && dataAtual.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) idade--;
        return idade;
    }
}
