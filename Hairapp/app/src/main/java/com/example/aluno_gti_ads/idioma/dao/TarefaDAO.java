package com.example.aluno_gti_ads.idioma.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aluno_gti_ads.idioma.model.Tarefas;
import com.example.aluno_gti_ads.idioma.model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiago.nakamura on 26/10/2017.
 */

public class TarefaDAO extends SQLiteOpenHelper {

    public TarefaDAO(Context context) {
        super(context, "Hairapp",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String stringTbTarefas = "CREATE TABLE Tarefas (id INTEGER PRIMARY KEY, usuId TEXT NOT NULL, horario TEXT NOT NULL, cliente TEXT NOT NULL, valor FLOAT NOT NULL, nomeTarefa TEXT NOT NULL);";
        db.execSQL(stringTbTarefas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS Tarefas";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserir(Tarefas tarefa) {
        //Nova instancia do db para poder usar o db.insert que anula o SQL INJECTION
        SQLiteDatabase db = getWritableDatabase();
        //CONTENT VALUES FAZ O TRATAMENTO DOS DADOS ANTES DE INSERIR NA TABELA
        ContentValues dadosTarefa = new ContentValues();
        dadosTarefa.put("horario", tarefa.getData().toString());
        dadosTarefa.put("cliente", tarefa.getTarefaCliente());
        dadosTarefa.put("valor", tarefa.getValor());
        dadosTarefa.put("usuId", tarefa.getUsuId());
        dadosTarefa.put("nomeTarefa", tarefa.getTarefaNome());





        db.insert("Tarefas", null, dadosTarefa);
    }

    public List<Tarefas> buscaTarefa(long userID) {

        String sql = "SELECT * FROM Tarefas where usuId ="+userID;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Tarefas> tarefas = new ArrayList<Tarefas>();

        while (c.moveToNext()) {
            Tarefas tarefa = new Tarefas();
            tarefa.setData(c.getString(c.getColumnIndex("horario")));
            tarefa.setTarefaNome(c.getString(c.getColumnIndex("nomeTarefa")));
            tarefa.setTarefaCliente(c.getString(c.getColumnIndex("cliente")));
            tarefa.setValor(c.getDouble(c.getColumnIndex("valor")));



            tarefas.add(tarefa);

        }
        c.close();

        return tarefas;
    }
}
