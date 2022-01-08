package com.example.pro_scoccer_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin, btnSa = null;
        EditText txtLogin, txtPass;
        TextView textCriarLogin, textMudarPass;

        LoginDAO LoginDAO;

        btnLogin = findViewById(R.id.btnLogin);
        txtLogin = findViewById(R.id.txtLogin);
        txtPass = findViewById(R.id.txtPass);
        btnSa = findViewById(R.id.btnSa);
        textCriarLogin = findViewById(R.id.textCriarLogin);
        textMudarPass = findViewById(R.id.textMudarPass);

        LoginDAO loginDAO = new LoginDAO(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String utilizador = txtLogin.getText().toString();
                String pass = txtPass.getText().toString();
                Boolean ResultcheckUtilizador = loginDAO.checkUtilizadorpalavraPasse(utilizador, pass);

                if(ResultcheckUtilizador == true)
                {
                    Intent intent = new Intent(loginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else if (utilizador.equals("admin") && pass.equals("admin"))
                {
                    Intent intent = new Intent(loginActivity.this, adminGestaoActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

        textCriarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity.this, CriarLogin.class);
                startActivity(intent);
            }
        });

        textMudarPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity.this, mudarPassActivity.class);
                startActivity(intent);
            }
        });

    }
}