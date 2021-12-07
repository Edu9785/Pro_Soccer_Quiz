package com.example.pro_scoccer_quiz;

public class Jogadores {
    public String NomeJogador;
    public int idade;
    public String clube;

    public Jogadores(String NomeJogador){
        this.NomeJogador = NomeJogador;
        this.idade = idade;
        this.clube = clube;
    }

    public String getNomeJogador() {
        return NomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        NomeJogador = nomeJogador;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }
}
