/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetofinal;
import java.util.Date;

/**
 *
 * @author flavio
 */
public class PorContribuicao extends Pessoa{
    private int flag;
    private float TempoRestante;
    Date d = new Date();

    public PorContribuicao(int dia, int mes, int ano, int tempoContribuicaoAno, int genero, int categoria){
        super(dia, mes, ano, tempoContribuicaoAno,genero, categoria);
        flag = 1;
        TempoRestante = 0;
    }

    public int max(int a , int b){
        if (a > b) return a;
        else return b;
    }

    public void IdadeProgressiva(){
        flag = 1;
        int ano = d.getYear() + 1900;
        int TempoContribuicao = this.getTempoContribuicaoAno();

        if(TempoContribuicao - (ano - 2019) < 15){
            flag  = 0;
            return;
        }

        else if(this.getGenero() == 1){
            TempoRestante = max(61 - this.getIdade(), 35 - TempoContribuicao);
            return;
        }
        else if(this.getGenero() == 2){
            TempoRestante = max(56 - this.getIdade(), 30 - TempoContribuicao);
            return;
        }

        if(TempoRestante <= 0) TempoRestante = 0;
    }


    public void Pedagio50(){
        flag = 1;
        int ano = d.getYear() + 1900;
        int TempoContribuicao = this.getTempoContribuicaoAno();

        int prereforma = TempoContribuicao - (ano - 2019);
        if(prereforma < 15){
            flag  = 0;
            return;
        }

        if(prereforma >= 33 && this.getGenero() == 1)
            TempoRestante = ((float)(35 - prereforma)/2) + (35 - TempoContribuicao);
        else if(prereforma >= 28 && this.getGenero() == 2)
            TempoRestante = ((float)(30 - prereforma)/2) + (30 - TempoContribuicao);
        else
            flag = 0;
      

        if(TempoRestante <= 0) TempoRestante = 0;
    }

    public void Pedagio100(){
        flag = 1;
        int ano = d.getYear() + 1900;
        int TempoContribuicao = this.getTempoContribuicaoAno();
        int prereforma = TempoContribuicao - (ano - 2019);

        if(TempoContribuicao - (ano - 2019) < 15){
            flag  = 0;
            return;
        }
        if(this.getGenero() == 1)
            TempoRestante = max((35 - prereforma)*2,60-this.getIdade());
        else if(this.getGenero() == 2)
            TempoRestante = max((30 - prereforma)*2,57-this.getIdade());

        if(TempoRestante <= 0) TempoRestante = 0;

    }


    public int getFlag(){
        return flag;
    }

    public float getTempoRestante(){
        return TempoRestante;
    }
    
    public static  void main(String[] args){
        PorContribuicao pc = new PorContribuicao(1, 1, 1970, 36, 1, 1);
        System.out.println("Idade: ");
        System.out.println(pc.getIdade());
        
        pc.IdadeProgressiva();
        System.out.println("Idade Progressiva");
        if (pc.getFlag() == 1){
            System.out.println(pc.getTempoRestante());
        } else System.out.println("Método Inválido");
        
        pc.Pedagio50();
        System.out.println("Pedagio 50%");
        if (pc.getFlag() == 1){
            System.out.println(pc.getTempoRestante());
        } else System.out.println("Método Inválido");
        
        pc.Pedagio100();
        System.out.println("Pedagio 100%");
        if (pc.getFlag() == 1){
            System.out.println(pc.getTempoRestante());
        } else System.out.println("Método Inválido");
    }

}
