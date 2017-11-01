package com.example.aluno_gti_ads.idioma.model;

/**
 * Created by tiago.nakamura on 25/10/2017.
 */

public class Usuario {

    private int usuId;

    public int getUsuId() {
        return usuId;
    }

    public void setUsuId(int usuId) {
        this.usuId = usuId;
    }

    public String getUsuNome() {
        return usuNome;
    }

    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    @Override
    public String toString() {
        return getUsuNome();
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    private String usuNome;
    private String usuSenha;
}
