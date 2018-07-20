package com.example.jesus.kendotrannig.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jesus.kendotrannig.R;
import com.example.jesus.kendotrannig.dao.ConfiguracaoFirebase;
import com.example.jesus.kendotrannig.model.Exercicio;
import com.example.jesus.kendotrannig.model.Treino;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TreinoActivity extends AppCompatActivity {

    private DatabaseReference treinoRef = ConfiguracaoFirebase.getDatabaseReference().child("Treino");
    private List<Treino> treinoList = new ArrayList<>();
    private FloatingActionButton floatingActionButton;
    private List<Exercicio> exercicioList = new ArrayList<>();
    private Date date = new Date();
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino);
        preferences = getSharedPreferences("dados.file", MODE_PRIVATE);
        editor = preferences.edit();
        setupViews();
        //conectarBanco();


    }

    private void setupViews() {
        floatingActionButton = findViewById(R.id.add_treino);
    }

    private void conectarBanco() {
        treinoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                treinoList.clear();
                for (DataSnapshot registro : dataSnapshot.getChildren()){
                    Treino treino = registro.getValue(Treino.class);
                    treinoList.add(treino);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void goToVideo(View view) {
        startActivity(new Intent(this, ReproducaoActivity.class));
    }
}
