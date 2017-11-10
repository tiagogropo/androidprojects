package com.example.aluno_gti_ads.idioma.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aluno_gti_ads.idioma.model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiago.nakamura on 25/10/2017.
 */

public class UsuarioDAO extends SQLiteOpenHelper {


    public UsuarioDAO(Context context) {
        super(context, "Hairapp", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Usuarios (id INTEGER PRIMARY KEY, nomeUsuario TEXT NOT NULL, senhaUsuario TEXT NOT NULL);";
        String stringTbTarefas = "CREATE TABLE Tarefas (id INTEGER PRIMARY KEY, usuId TEXT NOT NULL, horario TEXT NOT NULL, cliente TEXT NOT NULL, valor FLOAT NOT NULL, nomeTarefa TEXT NOT NULL);";
        db.execSQL(stringTbTarefas);
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS Usuarios";
        db.execSQL(sql);
        onCreate(db);
    }

    public long inserir(Usuario usuario) {

        long usuID;
        //Nova instancia do db para poder usar o db.insert que anula o SQL INJECTION
        SQLiteDatabase db = getWritableDatabase();
        //CONTENT VALUES FAZ O TRATAMENTO DOS DADOS ANTES DE INSERIR NA TABELA
        ContentValues dadosUsu = new ContentValues();
        dadosUsu.put("nomeUsuario", usuario.getUsuNome());
        dadosUsu.put("senhaUsuario", usuario.getUsuSenha());


        usuID = db.insert("Usuarios", null, dadosUsu);
        return usuID;
    }

    public List<Usuario> buscaUsuarios() {

        String sql = "SELECT * FROM Usuarios;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Usuario> usuarios = new ArrayList<Usuario>();

        while (c.moveToNext()) {
            Usuario usuario = new Usuario();
            usuario.setUsuNome(c.getString(c.getColumnIndex("nomeUsuario")));
            usuario.setUsuSenha(c.getString(c.getColumnIndex("senhaUsuario")));

            usuarios.add(usuario);

        }
        c.close();

        return usuarios;
    }

    public boolean verificaLogin(String user, String pass) {
        String sql = "SELECT * FROM Usuarios;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Usuario> usuarios = new ArrayList<Usuario>();

        while (c.moveToNext()) {
            if (c.getString(c.getColumnIndex("nomeUsuario")).toString().equals(user)) {
                if (c.getString(c.getColumnIndex("senhaUsuario")).toString().equals(pass)) {
                    return true;

                }


            }

        }
        return false;
    }
}
