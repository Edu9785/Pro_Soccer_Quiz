package com.example.pro_scoccer_quiz;

public class LoginBD {
    public String Utilizador;
    public String PalavraPass;

    public LoginBD (String Utilizador, String PalavraPass){
        this.Utilizador = Utilizador;
        this.PalavraPass = PalavraPass;
    }

    public String getPalavraPass() {
        return PalavraPass;
    }

    public String getUtilizador() {
        return Utilizador;
    }

    public void setPalavraPass(String palavraPass) {
        PalavraPass = palavraPass;
    }

    public void setUtilizador(String utilizador) {
        Utilizador = utilizador;
    }
}
