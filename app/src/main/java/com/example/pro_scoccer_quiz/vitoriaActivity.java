package com.example.pro_scoccer_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class vitoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitoria);

        Button btnSair2;

        btnSair2 = findViewById(R.id.btnSair2);

        btnSair2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vitoriaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}