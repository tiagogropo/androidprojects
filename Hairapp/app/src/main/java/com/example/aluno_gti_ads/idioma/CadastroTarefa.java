package com.example.aluno_gti_ads.idioma;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aluno_gti_ads.idioma.dao.TarefaDAO;
import com.example.aluno_gti_ads.idioma.model.Tarefas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CadastroTarefa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_tarefa);
        final long userID;

        Bundle extras = getIntent().getExtras();
        userID = extras.getLong("usuID", 0);

        final CadTarefaHelper cadTarefaHelper = new CadTarefaHelper(this);

        Button btnCadastroTarefa = (Button) findViewById(R.id.btnConfirmaTarefa);
        Button btnCadTarefaVoltar = (Button) findViewById(R.id.btnCadTarefaVoltar);
        final TextView txtHora = (TextView) findViewById(R.id.txtHora);

        final Calendar calendar = Calendar.getInstance();
        // Get the current hour and minute
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        final String date = df.format(Calendar.getInstance().getTime());


        //Feito com Format devido o horario aparecer 11:01 => 11:1
        txtHora.setText(String.format("%02d:%02d", hour, minute));

        btnCadastroTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cadTarefaHelper.validarCampos()) {

                    Tarefas tarefas = cadTarefaHelper.cadTarefa(userID, date);
                    TarefaDAO tarefaDao = new TarefaDAO(CadastroTarefa.this);
                    tarefaDao.inserir(tarefas);
                    tarefaDao.close();

                    Intent goToMain = new Intent(CadastroTarefa.this, MainActivity.class);
                    startActivity(goToMain);
                    finish();


                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CadastroTarefa.this);
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

        btnCadTarefaVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMain = new Intent(CadastroTarefa.this, MainActivity.class);
                startActivity(goToMain);
                finish();
            }
        });

        txtHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment dFragment = new TimePickerFragment();

                // Show the time picker dialog fragment
                dFragment.show(getFragmentManager(), "Time Picker");

            }

        });

    }


    @Override
    public void onBackPressed() {
        Intent goToMain = new Intent(CadastroTarefa.this, MainActivity.class);
        startActivity(goToMain);
        finish();
    }
}
