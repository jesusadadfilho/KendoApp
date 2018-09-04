package com.example.jesus.kendotrannig.app.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jesus.kendotrannig.R;
import com.example.jesus.kendotrannig.model.ExecercioRealizado;

import java.util.Collections;
import java.util.List;

public class ExerciciosRealizadosAdapter extends RecyclerView.Adapter<ExerciciosRealizadosAdapter.ExerciciosRealizadosViewHolder>  {


    private Context context;
    private List<ExecercioRealizado> execercioRealizadoList;

    public ExerciciosRealizadosAdapter(Context context, List<ExecercioRealizado> execercioRealizadoList) {
        this.context = context;
        this.execercioRealizadoList = execercioRealizadoList;
        Collections.sort(this.execercioRealizadoList);

    }


    @NonNull
    @Override
    public ExerciciosRealizadosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.activity_exercicio_realizado_view_holder, parent, false);

        return new ExerciciosRealizadosViewHolder(linha) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciciosRealizadosViewHolder holder, int position) {
        ExecercioRealizado execercioRealizado = execercioRealizadoList.get(position);

        holder.tempoExercicioRealizado.setText(execercioRealizado.getDataRealizada().toString());

    }

    @Override
    public int getItemCount() {
        return execercioRealizadoList.size();
    }

    public class ExerciciosRealizadosViewHolder extends RecyclerView.ViewHolder{

        private TextView nomeExercicioRealizado, tempoExercicioRealizado;
        public ExerciciosRealizadosViewHolder(View itemView) {
            super(itemView);
            nomeExercicioRealizado = itemView.findViewById(R.id.nome_exercicio_text);
            tempoExercicioRealizado = itemView.findViewById(R.id.data_exercicio_realizado_text);

        }
    }
}
