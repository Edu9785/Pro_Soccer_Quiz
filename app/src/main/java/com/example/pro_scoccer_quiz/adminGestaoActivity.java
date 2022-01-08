package com.example.pro_scoccer_quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class adminGestaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_gestao);

        Button btnApagarUtilizador;
        RecyclerView listUtilizadores;

        btnApagarUtilizador = findViewById(R.id.btnApagarUtilizadores);
        listUtilizadores = findViewById(R.id.listUtilizadores);

        LoginDAO LoginDAO = new LoginDAO(this);
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        recyclerView = (RecyclerView) findViewById(R.id.listUtilizadores);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<LoginBD> LoginBD = LoginDAO.getinformacaoList();

        MyAdapter myAdapter1 = new MyAdapter(LoginBD);
        recyclerView.setAdapter(myAdapter1);

        btnApagarUtilizador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adminGestaoActivity.this, apagarutilizadoresAtivity.class);
                startActivity(intent);
            }
        });
    }

}