package com.example.pro_scoccer_quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public class LoginDAO {

    private SQLiteDatabase db;
    private DbHelper dbHelper; // instância da classe que criamos

    private List<LoginBD> login;
    private LoginBD Login;

    public LoginDAO(Context context) {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void insertData(String Utilizador, String PalavraPass){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Utilizador", Utilizador);
        contentValues.put("PalavraPass", PalavraPass);
        db.insert("login", null, contentValues);
    }

    public Boolean checkUtilizador(String Utilizador)
    {
        Cursor cursor = db.rawQuery("select * from users where Utilizador = ?", new String[] {Utilizador});
        if(cursor.getCount() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean checkUtilizadorpalavraPasse(String Utilizador, String PalavraPass){
        Cursor cursor = db.rawQuery("select * from login where Utilizador = ? and PalavraPass = ?", new String[] {Utilizador, PalavraPass});
        if(cursor.getCount() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
