package com.example.aluno_gti_ads.idioma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroTarefa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_tarefa);

        Button btnCadastroTarefa = (Button) findViewById(R.id.btnConfirmaTarefa);
        Button btnCadTarefaVoltar = (Button) findViewById(R.id.btnCadTarefaVoltar);

        btnCadastroTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMenu = new Intent(CadastroTarefa.this, MainActivity.class);
                startActivity(goToMenu);
            }
        });

        btnCadTarefaVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
