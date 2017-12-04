package com.example.aluno_gti_ads.idioma;

import android.widget.EditText;
import android.widget.TextView;

import com.example.aluno_gti_ads.idioma.model.Tarefas;
import com.example.aluno_gti_ads.idioma.model.Usuario;

/**
 * Created by tiago.nakamura on 25/10/2017.
 */

public class CadTarefaHelper {
    EditText edtNomeCliente;
    EditText edtNomeTarefa;
    EditText edtValorTarefa;
    TextView txtHora;


    public CadTarefaHelper(CadastroTarefa cadTarefa){

        edtNomeCliente = (EditText) cadTarefa.findViewById(R.id.edtNomeCliente);
        edtNomeTarefa = (EditText) cadTarefa.findViewById(R.id.edtTarefaNome);
        edtValorTarefa = (EditText) cadTarefa.findViewById(R.id.edtTarefaValor);
        txtHora = (TextView) cadTarefa.findViewById(R.id.txtHora);


    }

    public Tarefas cadTarefa(long userID, String data){
        Tarefas tarefa = new Tarefas();
        tarefa.setTarefaCliente(edtNomeCliente.getText().toString());
        tarefa.setTarefaNome(edtNomeTarefa.getText().toString());
        tarefa.setValor(Double.parseDouble(edtValorTarefa.getText().toString()));
        tarefa.setHora(txtHora.getText().toString());
        tarefa.setData(data);
        tarefa.setUsuId((int)userID);



        return tarefa;

    }

    public boolean validarCampos(){

        if(edtNomeCliente.getText().toString().equals("") || edtNomeTarefa.getText().toString().equals("") || edtValorTarefa.getText().toString().equals("") || txtHora.getText().toString().equals("")){
            return false;

        }else{
            return  true;
        }


    }


}
