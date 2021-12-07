package com.example.pro_scoccer_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnJogar, btnSair;

        btnJogar = findViewById(R.id.btnjogar);
        btnSair = findViewById(R.id.btnSair);

        JogadoresDAO jogadoresDAO = new JogadoresDAO(this);
        PerguntasDAO perguntasDAO = new PerguntasDAO(this);


        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Jogo.class);
                startActivity(intent);
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

    }
}