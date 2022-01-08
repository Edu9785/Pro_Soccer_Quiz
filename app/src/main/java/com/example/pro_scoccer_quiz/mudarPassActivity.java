package com.example.pro_scoccer_quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class mudarPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mudar_pass);

        EditText txtPass, txtConfirmarPalavraPass, txtUtilizador;
        Button btnMudarPass;

        btnMudarPass = findViewById(R.id.btnMudarPass);
        txtPass = findViewById(R.id.txtPass);
        txtConfirmarPalavraPass = findViewById(R.id.txtConfirmarPalavraPass);
        txtUtilizador = findViewById(R.id.txtUtilizador);
        LoginDAO LoginDAO;
        LoginDAO = new LoginDAO(this);


        btnMudarPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = txtPass.getText().toString();
                String confPass = txtConfirmarPalavraPass.getText().toString();
                String utilizador = txtUtilizador.getText().toString();

                Boolean utilizadorcheckResult = LoginDAO.checkUtilizador(utilizador);
                if(utilizadorcheckResult == true)
                {
                    if(pass.equals(confPass)) {

                        LoginBD loginBD = new LoginBD(utilizador);
                        loginBD.setUtilizador(utilizador);
                        AlertDialog.Builder builder = new AlertDialog.Builder(mudarPassActivity.this);

                        builder.setTitle("Password");
                        builder.setMessage("Têm certeza que quer mudar a password?");

                        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                LoginDAO.updatepass(pass, loginBD);
                            }
                        });

                        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Ok a palavraPass não foi alterada", Toast.LENGTH_SHORT).show();
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "As palavras não são iguais", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Esse utilizador não existe", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}