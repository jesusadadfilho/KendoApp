package com.example.jesus.kendotrannig.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jesus.kendotrannig.R;
import com.example.jesus.kendotrannig.model.Treino;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irParaTreinos(View view) {
        startActivity(new Intent(this, TreinoActivity.class));
    }

    public void irParaExercicios(View view) {
        startActivity(new Intent(this, ExerciciosActivity.class));
    }
}
