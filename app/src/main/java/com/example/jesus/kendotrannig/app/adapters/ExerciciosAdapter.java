package com.example.jesus.kendotrannig.app.adapters;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jesus.kendotrannig.R;
import com.example.jesus.kendotrannig.app.ExecicioViewActivity;
import com.example.jesus.kendotrannig.app.ReproducaoActivity;
import com.example.jesus.kendotrannig.model.Exercicio;

import java.util.Collections;
import java.util.List;

public class ExerciciosAdapter extends RecyclerView.Adapter<ExerciciosAdapter.ExerciciosViewHolder> {

    private Context context;
    private List<Exercicio> exercicioList;

    public ExerciciosAdapter(Context context, List<Exercicio> exercicioList) {
        this.context = context;
        this.exercicioList = exercicioList;
        Collections.sort(this.exercicioList);
    }

    @NonNull
    @Override
    public ExerciciosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.activity_exercicio_view_holder, parent, false);

        return new ExerciciosViewHolder(linha) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciciosViewHolder holder, int position) {
        final Exercicio exercicio = this.exercicioList.get(position);

        holder.nomeExercicio.setText(exercicio.getNome());
        holder.nivelExercicio.setText("Nivel : " + exercicio.getNivel());
        Glide.with(context).load(exercicio.getImagem()).into(holder.imagemExercicio);
        holder.itemView.setOnClickListener( (view -> {
            Intent intent = new Intent(context,ExecicioViewActivity.class);
            intent.putExtra("link", exercicio.getVideoLink());
            intent.putExtra("nome", exercicio.getNome());
            intent.putExtra("tempo", exercicio.getTempo());
            intent.putExtra("exercicioId", exercicio.getId());
            intent.putExtra("imagemLink", exercicio.getImagem());
            intent.putExtra("descricao",exercicio.getDescricao());
            context.startActivity(intent);
        }));

        holder.itemView.setOnLongClickListener( (view -> {
            Toast.makeText(context,exercicio.getNome(),Toast.LENGTH_SHORT).show();
            return true;
        }));



}

    @Override
    public int getItemCount() {
        return this.exercicioList.size();
    }


    public static class ExerciciosViewHolder extends RecyclerView.ViewHolder{

        private TextView nomeExercicio, tempoExercicio, nivelExercicio;
        private ImageView imagemExercicio;
        public ExerciciosViewHolder(View itemView) {
            super(itemView);
            nomeExercicio = itemView.findViewById(R.id.nome_exercicio_text);
            tempoExercicio = itemView.findViewById(R.id.tempo_exercicio_text);
            nivelExercicio = itemView.findViewById(R.id.nivel_exercicio_text);
            imagemExercicio = itemView.findViewById(R.id.image_exercicio);

        }
    }
}
