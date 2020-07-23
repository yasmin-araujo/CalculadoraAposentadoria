/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetofinal;
import java.time.Year;

/**
 *
 * @author YasminAraujo
 */
public class PorPontos {
    int ano = Year.now().getValue();
    
    public int pontuacaoMinima(int genero, boolean eProf) {
        int pontuacao = 0;
        if (eProf == true) {
            if (genero == 1) {
                if (ano >= 2035) pontuacao = 100;
                else pontuacao = ano - 2019 + 91;
            } else if (genero == 2) {
                if (ano >= 2035) pontuacao = 95;
                else pontuacao = ano - 2019 + 81;
            } 
        } else {
            if (genero == 1) {
                if (ano >= 2035) pontuacao = 105;
                else pontuacao = ano - 2019 + 96;
            } else if (genero == 2) {
                if (ano >= 2035) pontuacao = 100;
                else pontuacao = ano - 2019 + 86;
            }
        }
        return pontuacao;
    }
    
    private int recalcularPontuacao(int pontosRestante, int pontuacao) {
        int contador = 0;
        while (pontosRestante != 0) {
            ano++;
            pontuacao += 2;
            pontosRestante = pontuacaoMinima(1, true) - pontuacao;
            contador++;
        }
        ano = Year.now().getValue();
        return contador;      
    }

    public int calcular(Pessoa p) {
        int pontuacao = p.getIdade() + p.getTempoContribuicaoAno();
        int tempoRestante = 0;
        int pontosRestante;
        if (p.getCategoria() == 3) {
            if (p.getGenero() == 1) {
                pontosRestante = pontuacaoMinima(1, true) - pontuacao;
            } else {
                pontosRestante = pontuacaoMinima(2, true) - pontuacao;
            }
        } else {
            if (p.getGenero() == 1) {
                pontosRestante = pontuacaoMinima(1, false) - pontuacao;
            } else {
                pontosRestante = pontuacaoMinima(2, false) - pontuacao;
            }
        }
      
        tempoRestante = recalcularPontuacao(pontosRestante, pontuacao);
        
        return tempoRestante;
    }
    
    public static void main(String[] args) {
        Pessoa p = new Pessoa(8, 1, 1970, 35, 8, 1, 1);
        PorPontos calculadora = new PorPontos();
        
        int tempoRestante = calculadora.calcular(p);
        System.out.println(tempoRestante);
    }
}
