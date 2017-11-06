package com.example.aluno_gti_ads.idioma;

import android.widget.EditText;

import com.example.aluno_gti_ads.idioma.model.Tarefas;
import com.example.aluno_gti_ads.idioma.model.Usuario;

/**
 * Created by tiago.nakamura on 25/10/2017.
 */

public class CadTarefaHelper {
    EditText edtNomeCliente;
    EditText edtNomeTarefa;
    EditText edtValorTarefa;


    public CadTarefaHelper(CadastroUsuActivity cadUsuarioActivity){

        edtNomeCliente = (EditText) cadUsuarioActivity.findViewById(R.id.edtNomeCliente);
        edtNomeTarefa = (EditText) cadUsuarioActivity.findViewById(R.id.edtTarefaNome);


    }

    public Tarefas cadTarefa(){
        Tarefas tarefa = new Tarefas();
        tarefa.setTarefaCliente(edtNomeCliente.getText().toString());
        tarefa.setTarefaNome(edtNomeTarefa.getText().toString());
        tarefa.setValor(Double.parseDouble(edtValorTarefa.getText().toString()));



        return tarefa;

    }


}
