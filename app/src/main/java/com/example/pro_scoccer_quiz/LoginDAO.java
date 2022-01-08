package com.example.pro_scoccer_quiz;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class LoginDAO {

    private SQLiteDatabase db;
    private DbHelper dbHelper; // instância da classe que criamos

    private List<LoginBD> login = new ArrayList<>();
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
        Cursor cursor = db.rawQuery("select * from login where Utilizador = '" + Utilizador + "'",null);
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

        Cursor cursor = db.rawQuery("select * from login where Utilizador = '" + Utilizador + "' and PalavraPass = '" + PalavraPass + "'",null);
        if(cursor.getCount() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void updatepass(String PalavraPass, LoginBD login)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("PalavraPass", PalavraPass);
        Log.d("", "updatepass:" + login.getUtilizador().toString());
        db.update("login", contentValues, "Utilizador = ?", new String[] {login.getUtilizador().toString()});
    }

        @SuppressLint("Range")
        public ArrayList<LoginBD> getinformacaoList() {
            String strSql = "select * from login";
            ArrayList<LoginBD> Login1 = new ArrayList<LoginBD>();
            db = dbHelper.getReadableDatabase();
            Cursor c = db.rawQuery(strSql, null);
            if (c.moveToFirst()) {
                do {
                    Log.i("vv", "getinformacaoList:dd ");
                    Login = new LoginBD();
                    Login.setUtilizador(c.getString(c.getColumnIndex("Utilizador")));
                    Login.setPalavraPass(c.getString(c.getColumnIndex("PalavraPass")));
                    Log.i("vv", "getinformacaoList: xix");
                    Login1.add(Login);
                    Log.i("vv", "getinformacaoList: " + Login.getUtilizador() + ", " + Login.getPalavraPass());
                } while (c.moveToNext());
                Log.i("vv", "getinformacaoList: FFF");
            }
            Log.i("vv", "getinformacaoList: NOP");
            return Login1;
        }
}
