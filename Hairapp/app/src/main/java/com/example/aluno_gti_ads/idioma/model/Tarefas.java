package com.example.aluno_gti_ads.idioma.model;

import java.sql.Date;

/**
 * Created by tiago.nakamura on 25/10/2017.
 */

public class Tarefas {

    private int tarefaId;

    public int getTarefaId() {
        return tarefaId;
    }

    public void setTarefaId(int tarefaId) {
        this.tarefaId = tarefaId;
    }

    public String getTarefaNome() {
        return tarefaNome;
    }

    public void setTarefaNome(String tarefaNome) {
        this.tarefaNome = tarefaNome;
    }

    public String getTarefaCliente() {
        return tarefaCliente;
    }

    public void setTarefaCliente(String tarefaCliente) {
        this.tarefaCliente = tarefaCliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    private String tarefaNome;
    private String tarefaCliente;
    private Double valor;
    private Date data;



    @Override
    public String toString() {
        return getTarefaNome();
    }




}