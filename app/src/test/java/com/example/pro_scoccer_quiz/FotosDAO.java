package com.example.pro_scoccer_quiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public class FotosDAO {

    private SQLiteDatabase db;
    private DbHelper dbHelper; // instância da classe que criamos

    private List<Jogadores> jogadores;
    private Jogadores jOgadores;

    public FotosDAO(Context context) {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
}
