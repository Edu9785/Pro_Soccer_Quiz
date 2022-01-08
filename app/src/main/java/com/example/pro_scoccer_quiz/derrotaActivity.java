package com.example.pro_scoccer_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class derrotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derrota);

        String NomeJogador = "Messi";

        Button btnres, btns = null;
        TextView txtResposta;

        btnres = findViewById(R.id.btnres);
        txtResposta = findViewById(R.id.txtResposta);
        btns = findViewById(R.id.btns);

        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jogadores jogadores = new Jogadores(NomeJogador);
                jogadores.setNomeJogador(NomeJogador);
                txtResposta.setText("A resposta certa seria: " + jogadores.getNomeJogador());

            }
        });

        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(derrotaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}