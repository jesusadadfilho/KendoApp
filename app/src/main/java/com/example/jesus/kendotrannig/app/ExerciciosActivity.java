package com.example.jesus.kendotrannig.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jesus.kendotrannig.R;
import com.example.jesus.kendotrannig.app.adapters.ExerciciosAdapter;
import com.example.jesus.kendotrannig.dao.ConfiguracaoFirebase;
import com.example.jesus.kendotrannig.model.Exercicio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExerciciosActivity extends AppCompatActivity {

    private DatabaseReference exerciciosRef = ConfiguracaoFirebase.getDatabaseReference().child("exercicio");
    private List<Exercicio> exercicioList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ExerciciosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios);
        setupViews();
        conectarBanco();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        adapter = new ExerciciosAdapter(this,exercicioList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    private void setupViews() {
        recyclerView = findViewById(R.id.rv_exercicios);
    }

    private void conectarBanco() {
        exerciciosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                exercicioList.clear();
                for (DataSnapshot registro : dataSnapshot.getChildren()){
                    Exercicio exercicio = registro.getValue(Exercicio.class);
                    exercicioList.add(exercicio);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
