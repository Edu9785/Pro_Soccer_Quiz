package com.example.pro_scoccer_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CriarLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_login);

        EditText txtUtilizador, txtpalavraPasse, txtConfirmarPalavraPass;
        Button btnCriarConta = null;
        LoginDAO LoginDAO;

        txtUtilizador = findViewById(R.id.txtUtilizador);
        txtpalavraPasse = findViewById(R.id.txtPalavraPass);
        txtConfirmarPalavraPass = findViewById(R.id.txtConfirmarPalavraPass);
        btnCriarConta = findViewById(R.id.btnMudarPass);
        LoginDAO = new LoginDAO(this);

        LoginDAO loginDAO = new LoginDAO(this);

        btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String utilizador = txtUtilizador.getText().toString();
                String pass = txtpalavraPasse.getText().toString();
                String confPass = txtConfirmarPalavraPass.getText().toString();

                if(utilizador.equals("") || pass.equals("") || confPass.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(pass.equals(confPass))
                    {
                        Boolean utilizadorcheckResult = loginDAO.checkUtilizador(utilizador);
                        if(utilizadorcheckResult == false)
                        {
                            loginDAO.insertData(utilizador, pass);
                            Toast.makeText(getApplicationContext(), "Conta criada com sucesso", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "O Utilizador já existe", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "As palavras não são iguais", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}