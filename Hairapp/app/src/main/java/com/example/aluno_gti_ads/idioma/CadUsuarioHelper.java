package com.example.aluno_gti_ads.idioma;

import android.widget.EditText;

import com.example.aluno_gti_ads.idioma.model.Usuario;

/**
 * Created by tiago.nakamura on 25/10/2017.
 */

public class CadUsuarioHelper {
    EditText edtCadUsuNome;
    EditText edtCadUsuSenha;


    public CadUsuarioHelper(CadastroUsuActivity cadUsuarioActivity){

        edtCadUsuNome = (EditText) cadUsuarioActivity.findViewById(R.id.edtNomeCadUsuario);
        edtCadUsuSenha = (EditText) cadUsuarioActivity.findViewById(R.id.edtSenhaCadUsuario);


    }

    public Usuario cadUsuario(){
        Usuario usuario = new Usuario();
        usuario.setUsuNome(edtCadUsuNome.getText().toString());
        usuario.setUsuSenha(edtCadUsuSenha.getText().toString());

        return usuario;

    }

    public boolean validarCampos(){

        if(edtCadUsuSenha.getText().toString().equals("") || edtCadUsuNome.getText().toString().equals("")){
            return false;

        }else{
            return  true;
        }


    }


}
