package com.example.pro_scoccer_quiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class PerguntasDAO {

    private SQLiteDatabase db;
    private DbHelper dbHelper; // instância da classe que criamos

    private List<perguntas> perguntas;
    private Jogadores jOgadores;

    public PerguntasDAO(Context context) {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
}
