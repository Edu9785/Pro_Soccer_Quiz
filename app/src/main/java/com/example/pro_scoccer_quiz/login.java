package com.example.pro_scoccer_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin, btnSa = null;
        EditText txtLogin, txtPass;
        TextView textCriarLogin;

        LoginDAO LoginDAO;

        btnLogin = findViewById(R.id.btnLogin);
        txtLogin = findViewById(R.id.txtLogin);
        txtPass = findViewById(R.id.txtPass);
        btnSa = findViewById(R.id.btnSa);
        textCriarLogin = findViewById(R.id.textCriarLogin);

        LoginDAO loginDAO = new LoginDAO(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (txtLogin.getText().toString().equals("admin") && txtPass.getText().toString().equals("123"))
                {
                    Intent intent = new Intent(login.this, MainActivity.class);
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
                Intent intent = new Intent(login.this, CriarLogin.class);
                startActivity(intent);
            }
        });

    }
}