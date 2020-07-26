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
                if (ano >= 2028) pontuacao = 100;
                else pontuacao = ano - 2019 + 91;
            } else if (genero == 2) {
                if (ano >= 2033) pontuacao = 95;
                else pontuacao = ano - 2019 + 81;
            } 
        } else {
            if (genero == 1) {
                if (ano >= 2028) pontuacao = 105;
                else pontuacao = ano - 2019 + 96;
            } else if (genero == 2) {
                if (ano >= 2033) pontuacao = 100;
                else pontuacao = ano - 2019 + 86;
            }
        }
        return pontuacao;
    }
    
    private int recalcularPontuacao(int pontosRestante, int pontuacao, int genero, boolean eProf) {
        int contador = 0;
        while (pontosRestante > 0) {
            ano++;
            pontuacao += 2;
            pontosRestante = pontuacaoMinima(genero, eProf) - pontuacao;
            contador++;
        }
        ano = Year.now().getValue();
        return contador;      
    }

    public int calcular(Pessoa p) {
        int pontuacao = p.getIdade() + p.getTempoContribuicaoAno();
        //if (p.getIdadeMes() + p.getTempoContribuicaoMes() >= 12)
        //    pontuacao++;
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
      
        tempoRestante = recalcularPontuacao(pontosRestante, pontuacao, p.getGenero(), p.getCategoria() == 3);
        
        return tempoRestante;
    }
    
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(25, 07, 1980, 25, 0, 1, 1);
        Pessoa p2 = new Pessoa(25, 07, 1980, 25, 0, 2, 1);
        Pessoa p3 = new Pessoa(8, 1, 1970, 35, 8, 1, 3);
        PorPontos calculadora = new PorPontos();
        
        int tempoRestante = calculadora.calcular(p2);
        System.out.println(tempoRestante);
    }
}
