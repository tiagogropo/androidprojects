package com.example.aluno_gti_ads.idioma;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aluno_gti_ads.idioma.dao.UsuarioDAO;

public class LoginActivity extends AppCompatActivity {

    public String user;
    public String senha;
    public Long usuID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        final SharedPreferences.Editor editor = pref.edit();

        Button btnConfirma = (Button) findViewById(R.id.btnConfirmaLogin);
        Button btnCadastrese = (Button) findViewById(R.id.btnCadastraUsuario);
        final EditText edtNomeUsu = (EditText) findViewById(R.id.edtUser);
        final EditText edtSenhaUsu = (EditText) findViewById(R.id.edtPassword);

        user = pref.getString("user", "");
        senha = pref.getString("senha", "");
        usuID = pref.getLong("usuID", 0);
        if (!user.equals("")) {
            Intent loginToMain = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(loginToMain);
            loginToMain.putExtra("putUser", user);
            loginToMain.putExtra("putSenha", senha);
            loginToMain.putExtra("usuID", usuID);
        }


        btnCadastrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginToCadastro = new Intent(LoginActivity.this, CadastroUsuActivity.class);
                startActivity(loginToCadastro);
            }
        });
        btnConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!edtNomeUsu.getText().toString().equals("") || !edtSenhaUsu.getText().toString().equals("")) {

                    UsuarioDAO usuDao = new UsuarioDAO(LoginActivity.this);
                    if (usuDao.verificaLogin(edtNomeUsu.getText().toString(), edtSenhaUsu.getText().toString())) {

                        long usuID = usuDao.getID();


                        user = edtNomeUsu.getText().toString();
                        senha = edtSenhaUsu.getText().toString();
                        editor.putString("user", user); // Storing string
                        editor.putString("senha", senha); // Storing string
                        editor.putLong("usuID", usuID); // Storing string
                        editor.commit();

                        Intent loginToMain = new Intent(LoginActivity.this, MainActivity.class);
                        loginToMain.putExtra("usuID", usuID);
                        startActivity(loginToMain);
                        finish();
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Todos os campos devem ser preenchidos!")
                            .setTitle("Erro");
                    // Add the buttons
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }


            }
        });
    }
}
