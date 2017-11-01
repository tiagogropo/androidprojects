package com.example.aluno_gti_ads.idioma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.aluno_gti_ads.idioma.dao.UsuarioDAO;
import com.example.aluno_gti_ads.idioma.model.Usuario;

public class CadastroUsuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        final CadUsuarioHelper cadUsuHelper = new CadUsuarioHelper(this);

        Button btnCadUsuaVoltar = (Button) findViewById(R.id.btnCadUsuarioVoltar);
        Button btnCadUsuaCadastrar = (Button) findViewById(R.id.btnConfirmaLogin);

        btnCadUsuaCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Usuario usuario = cadUsuHelper.cadUsuario();
                    UsuarioDAO usuDao = new UsuarioDAO(CadastroUsuActivity.this);
                    usuDao.inserir(usuario);
                    usuDao.close();
                    Intent goToMenu = new Intent(CadastroUsuActivity.this, MainActivity.class);
                    startActivity(goToMenu);
                    finish();

                }
                catch(Exception e){
                    Toast.makeText(CadastroUsuActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnCadUsuaVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
