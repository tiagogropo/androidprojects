package com.example.aluno_gti_ads.idioma;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class SelecionaIdiomaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lerIdioma();

        setContentView(R.layout.activity_seleciona_idioma);
        Button btnConfirmar = (Button) findViewById(R.id.btnConfirmaIdioma);
        Button btnSair = (Button) findViewById(R.id.btnCancelaIdioma);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent languageToLogin = new Intent(SelecionaIdiomaActivity.this, LoginActivity.class);
                startActivity(languageToLogin);
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public void lerIdioma(){
        SharedPreferences dados = getSharedPreferences("languageRoot",MODE_PRIVATE);
        String idioma = dados.getString("idioma","pt");

        Configuration config = this.getResources().getConfiguration();
        Locale local = new Locale(idioma);
        Locale.setDefault(local);
        config.setLocale(local);
        this.getResources().updateConfiguration(config, this.getResources().getDisplayMetrics());
    }

    public void setlocalePt(View v){
        Locale local = new Locale("pt");
        Locale.setDefault(local);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.setLocale(local);
        this.getResources().updateConfiguration(config, this.getResources().getDisplayMetrics());
        SharedPreferences.Editor dados = (SharedPreferences.Editor) getSharedPreferences("languageRoot",MODE_PRIVATE).edit();
        dados.putString("idioma", "pt");
        dados.commit();
        recreate();
    }
    public void setlocaleEs(View v){
        Locale local = new Locale("es");
        Locale.setDefault(local);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.setLocale(local);
        this.getResources().updateConfiguration(config, this.getResources().getDisplayMetrics());
        SharedPreferences.Editor dados = (SharedPreferences.Editor) getSharedPreferences("languageRoot",MODE_PRIVATE).edit();
        dados.putString("idioma", "es");
        dados.commit();
        recreate();
    }
    public void setlocaleUs(View v){
        Locale local = new Locale("en");
        Locale.setDefault(local);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.setLocale(local);
        this.getResources().updateConfiguration(config, this.getResources().getDisplayMetrics());
        SharedPreferences.Editor dados = (SharedPreferences.Editor) getSharedPreferences("languageRoot",MODE_PRIVATE).edit();
        dados.putString("idioma", "en");
        dados.commit();
        recreate();
    }
    public void setlocaleFr(View v){
        Locale local = new Locale("fr");
        Locale.setDefault(local);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.setLocale(local);
        this.getResources().updateConfiguration(config, this.getResources().getDisplayMetrics());
        SharedPreferences.Editor dados = (SharedPreferences.Editor) getSharedPreferences("languageRoot",MODE_PRIVATE).edit();
        dados.putString("idioma", "fr");
        dados.commit();
        recreate();
    }
    public void setlocaleGer(View v){
        Locale local = new Locale("de");
        Locale.setDefault(local);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.setLocale(local);
        this.getResources().updateConfiguration(config, this.getResources().getDisplayMetrics());
        SharedPreferences.Editor dados = (SharedPreferences.Editor) getSharedPreferences("languageRoot",MODE_PRIVATE).edit();
        dados.putString("idioma", "de");
        dados.commit();
        recreate();
    }

}
