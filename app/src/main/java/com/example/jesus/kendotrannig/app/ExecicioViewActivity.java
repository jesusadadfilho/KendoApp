package com.example.jesus.kendotrannig.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jesus.kendotrannig.R;
import com.example.jesus.kendotrannig.app.adapters.ExerciciosRealizadosAdapter;
import com.example.jesus.kendotrannig.model.ExecercioRealizado;

import java.util.ArrayList;
import java.util.List;

public class ExecicioViewActivity extends AppCompatActivity {

    private TextView nomeExercicioText, tempoExercicioText;
    private String link, nome, imagemLink;
    private ImageView exercicioImage;
    private int tempo, exercicioId;
    private RecyclerView exerciciosRealizadosRV;
    private List<ExecercioRealizado> execercioRealizadoList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_execicio_view);
        link = getIntent().getStringExtra("link");
        nome = getIntent().getStringExtra("nome");
        tempo = getIntent().getIntExtra("tempo",0);
        exercicioId = getIntent().getIntExtra("exercicioId",0);
        imagemLink = getIntent().getStringExtra("imagemLink");
        setupRecyclerView();
        setupViews();


    }

    private void setupViews() {
        nomeExercicioText = findViewById(R.id.nome_exercicio);
        tempoExercicioText = findViewById(R.id.tempo_exercicio_text);
        exercicioImage = findViewById(R.id.imagem_exercicio);
        exerciciosRealizadosRV = findViewById(R.id.rv_exercicios_feitos);
        Glide.with(this).load(imagemLink).into(exercicioImage);
    }

    private void setupRecyclerView() {
        ExerciciosRealizadosAdapter adapter = new ExerciciosRealizadosAdapter(this, execercioRealizadoList);
        exerciciosRealizadosRV.setAdapter(adapter);
        exerciciosRealizadosRV.setLayoutManager(new LinearLayoutManager(this));
        exerciciosRealizadosRV.setHasFixedSize(true);
    }


    public void playVideo(View view) {
        Intent intent = new Intent(this,ExecicioViewActivity.class);
        intent.putExtra("link", link);
        startActivity(intent);
    }
}
