package com.example.jesus.kendotrannig.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    private DatabaseReference treinoRef = ConfiguracaoFirebase.getDatabaseReference().child("treino");
    private List<Treino> treinoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino);
        conectarBanco();

    }

    private void conectarBanco() {
        treinoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
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
}
