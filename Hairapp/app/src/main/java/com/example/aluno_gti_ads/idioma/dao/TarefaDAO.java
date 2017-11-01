package com.example.aluno_gti_ads.idioma.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aluno_gti_ads.idioma.model.Usuario;

/**
 * Created by tiago.nakamura on 26/10/2017.
 */

public class TarefaDAO extends SQLiteOpenHelper {

    public TarefaDAO(Context context) {
        super(context, "Hairapp",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String stringTbTarefas = "CREATE TABLE Tarefas (id INTEGER PRIMARY KEY AUTOINCREMENT, usuId TEXT NOT NULL, horario DATETIME NOT NULL, cliente TEXT NOT NULL, servico TEXT NOT NULL, valor FLOAT NOT NULL);";
        String stringTbUsuarios = "CREATE TABLE Usuarios (id INTEGER PRIMARY KEY, nomeUsuario TEXT NOT NULL, senhaUsuario TEXT NOT NULL);";
        db.execSQL(stringTbTarefas);
        db.execSQL(stringTbUsuarios);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS Usuarios";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserir(Usuario usuario) {
        //Nova instancia do db para poder usar o db.insert que anula o SQL INJECTION
        SQLiteDatabase db = getWritableDatabase();
        //CONTENT VALUES FAZ O TRATAMENTO DOS DADOS ANTES DE INSERIR NA TABELA
        ContentValues dadosUsu = new ContentValues();
        dadosUsu.put("nomeUsuario", usuario.getUsuNome());
        dadosUsu.put("senhaUsuario", usuario.getUsuSenha());


        db.insert("Usuarios", null, dadosUsu);
    }
}
