/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetofinal;

import java.util.Date;

/**
 *
 * @author YasminAraujo
 */

public class Pessoa {
    private Date dataNascimento;
    private int tempoContribuicaoAno;
    private int tempoContribuicaoMes;
    private int genero; 
    private int categoria;
    
    public Pessoa(int dia, int mes, int ano, int tempoContribuicaoAno, int tempoContribuicaoMes, int genero, int categoria)
    {
        dataNascimento = new Date(ano, mes, dia);
        this.tempoContribuicaoAno = tempoContribuicaoAno;
        this.tempoContribuicaoMes = tempoContribuicaoMes;
        this.genero = genero;
        this.categoria = categoria;
    }

    public void setDataNascimento(Date dataNascimento) {
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

    public Date getDataNascimento() {
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
    
}
