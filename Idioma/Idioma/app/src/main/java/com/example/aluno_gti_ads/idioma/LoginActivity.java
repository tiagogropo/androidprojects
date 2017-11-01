package com.example.aluno_gti_ads.idioma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnConfirma = (Button) findViewById(R.id.btnConfirmaCadastro);
        Button btnCadastrese = (Button) findViewById(R.id.btnCanceleCadastro);
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
                Intent loginToMain = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(loginToMain);

            }
        });
    }
}
