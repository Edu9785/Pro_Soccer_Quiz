package com.example.pro_scoccer_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Jogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        Button btnRonaldo, btnMbappe, btnMessi, btnBenzema;

        btnBenzema = findViewById(R.id.btnBenzema);
        btnRonaldo = findViewById(R.id.btnRonaldo);
        btnMessi = findViewById(R.id.btnMessi);
        btnMbappe = findViewById(R.id.btnMbappe);
        String Nomejogador = "Messi";



        btnMessi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Jogo.this, Vitoria.class);
                startActivity(intent);
            }
        });

        btnRonaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Jogo.this, Derrota.class);
                startActivity(intent);
            }
        });

        btnMbappe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Jogo.this, Derrota.class);
                startActivity(intent);
            }
        });

        btnBenzema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Jogo.this, Derrota.class);
                startActivity(intent);
            }
        });
    }
}