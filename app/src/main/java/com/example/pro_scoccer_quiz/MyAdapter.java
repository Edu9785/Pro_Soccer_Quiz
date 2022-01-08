package com.example.pro_scoccer_quiz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<LoginBD> Login = new ArrayList<LoginBD>();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtutilizador;
        public TextView txtpass;

        public ViewHolder(View view) {
            super(view);
            txtutilizador = (TextView) view.findViewById(R.id.txtutilizador);
            txtpass = (TextView) view.findViewById(R.id.txtpass);
        }
    }

    public MyAdapter(ArrayList<LoginBD> Logibd) {
        Login = Logibd;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reciclerviewladapter, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       String utilizador = Login.get(position).getUtilizador();
       String pass = Login.get(position).getPalavraPass();
       holder.txtpass.setText(pass);
       holder.txtutilizador.setText(utilizador);
    }

    @Override
    public int getItemCount(){
        return Login.size();
    }
}


