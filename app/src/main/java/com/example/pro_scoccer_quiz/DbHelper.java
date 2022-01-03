package com.example.pro_scoccer_quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bd_Jogo";
    public static final String TABLE_LOGIN = "Login";
    private static final int DATABASE_VERSION = 1;


    public static final String tablelogin = "create table login"
            + "(id_login integer primary key autoincrement,"
            + " Utilizador text not null,"
            + " PalavraPass text not null)";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablelogin);
        Log.i("bd", "Bd criada com sucesso");
    }

   @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + tablelogin);
        //onCreate(db);
    }

}

