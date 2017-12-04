package com.example.aluno_gti_ads.idioma;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

                if (cadUsuHelper.validarCampos()) {


                    try {
                        Usuario usuario = cadUsuHelper.cadUsuario();
                        UsuarioDAO usuDao = new UsuarioDAO(CadastroUsuActivity.this);
                        long usuID = usuDao.inserir(usuario);
                        usuDao.close();

                        //Resetando shared preferences ao criar usuario novo
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                        final SharedPreferences.Editor editor = pref.edit();
                        editor.putString("user", ""); // Storing string
                        editor.putString("senha", ""); // Storing string
                        editor.putLong("usuID", usuID); // Storing string
                        editor.commit();

                        AlertDialog.Builder builder = new AlertDialog.Builder(CadastroUsuActivity.this);
                        builder.setMessage("Usuário cadastrado com sucesso")
                                .setTitle("Sucesso");
                        // Add the buttons
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                //Indo para proxima activity
                                Intent goToLogin = new Intent(CadastroUsuActivity.this, LoginActivity.class);
                                startActivity(goToLogin);
                                finish();
                            }
                        });

// Create the AlertDialog
                        AlertDialog dialog = builder.create();
                        dialog.show();


                    } catch (Exception e) {
                        Toast.makeText(CadastroUsuActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }

                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(CadastroUsuActivity.this);
                    builder.setMessage("Todos os campos devem ser preenchidos!")
                            .setTitle("Erro");
                    // Add the buttons
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            
                        }
                    });

// Create the AlertDialog
                    AlertDialog dialog = builder.create();
                    dialog.show();
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
