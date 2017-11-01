package com.example.aluno_gti_ads.idioma;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class SelecionaIdiomaActivity extends Activity {
    SharedPreferences dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lerIdioma();
        dados = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        final SharedPreferences.Editor editor = dados.edit();
        String idioma = dados.getString("idioma", null);
        setContentView(R.layout.activity_seleciona_idioma);

        if (idioma != null) {

            Intent languageToLogin = new Intent(SelecionaIdiomaActivity.this, LoginActivity.class);
            startActivity(languageToLogin);
        }
        CircleImageView btnPtbr = (CircleImageView) findViewById(R.id.imgBtnPtBR);
        btnPtbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale local = new Locale("pt");
                Locale.setDefault(local);
                android.content.res.Configuration config = new android.content.res.Configuration();
                config.setLocale(local);
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                editor.putString("idioma", "pt");
                editor.commit();
                recreate();



            }
        });

        CircleImageView btnEsp = (CircleImageView) findViewById(R.id.imgBtnES);
        btnEsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale local = new Locale("es");
                Locale.setDefault(local);
                android.content.res.Configuration config = new android.content.res.Configuration();
                config.setLocale(local);
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                editor.putString("idioma", "es");
                editor.commit();
                recreate();

            }
        });


        CircleImageView btnGerm = (CircleImageView) findViewById(R.id.imgBtnGer);
        btnGerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale local = new Locale("de");
                Locale.setDefault(local);
                android.content.res.Configuration config = new android.content.res.Configuration();
                config.setLocale(local);
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                editor.putString("idioma", "de");
                editor.commit();
                recreate();

            }
        });

        CircleImageView btnUs = (CircleImageView) findViewById(R.id.imgBtnEn);
        btnUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale local = new Locale("en");
                Locale.setDefault(local);
                android.content.res.Configuration config = new android.content.res.Configuration();
                config.setLocale(local);
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                editor.putString("idioma", "en");
                editor.commit();
                recreate();


            }
        });

        CircleImageView btnFr = (CircleImageView) findViewById(R.id.imgBtnFr);
        btnFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale local = new Locale("fr");
                Locale.setDefault(local);
                android.content.res.Configuration config = new android.content.res.Configuration();
                config.setLocale(local);
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                editor.putString("idioma", "fr");
                editor.commit();
                recreate();


            }
        });




    }
    public void lerIdioma(){
        SharedPreferences dados = getSharedPreferences("MyPref",MODE_PRIVATE);
        String idioma = dados.getString("idioma","pt");

        Configuration config = this.getResources().getConfiguration();
        Locale local = new Locale(idioma);
        Locale.setDefault(local);
        config.setLocale(local);
        this.getResources().updateConfiguration(config, this.getResources().getDisplayMetrics());
    }



}
