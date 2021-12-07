package com.example.pro_scoccer_quiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bd_Jogadores";
    public static final String TABLE_JOGADORES = "Jogadores";
    private static final int DATABASE_VERSION = 1;

    // String para criação da tabela tarefa
    public static final String tablejogadores = "create table jogador"
            + "(id_Jogador integer primary key autoincrement,"
            + " Nome text not null,"
            + " Idade integer not null,"
            + " Clube integer not null)";


    public static final String tableperguntas = "create table perguntas"
            + "(id_pergunta integer primary key autoincrement,"
            + " pergunta text not null)";

    public static final String tablefotos = "create table fotos"
            + "(id_fotos integer primary key autoincrement,"
            + " foto BLOB not null)";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablejogadores);
        Log.i("bd", "Bd criada com sucesso");
    }

   @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + tablejogadores);
        //onCreate(db);
    }
}

