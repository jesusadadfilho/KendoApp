package com.example.jesus.kendotrannig.model;

import android.support.annotation.NonNull;

import com.example.jesus.kendotrannig.app.ExecicioViewActivity;

import java.util.Date;
import java.util.List;

public class ExecercioRealizado implements Comparable<ExecercioRealizado> {
    private int exercicioId;
    private String tempo;
    private Date dataRealizada;



    public int getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(int exercicioId) {
        this.exercicioId = exercicioId;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public Date getDataRealizada() {
        return dataRealizada;
    }

    public void setDataRealizada(Date dataRealizada) {
        this.dataRealizada = dataRealizada;
    }


    @Override
    public int compareTo(@NonNull ExecercioRealizado execercioRealizado) {
        return getDataRealizada().compareTo(execercioRealizado.dataRealizada);
    }
}
