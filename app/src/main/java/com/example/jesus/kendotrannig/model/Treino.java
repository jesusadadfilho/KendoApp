package com.example.jesus.kendotrannig.model;

import java.util.Date;
import java.util.List;

public class Treino {
    private long userId;
    private List<Exercicio> exercicioList;
    private String data;

    public Treino() {
    }

    public Treino(long userId, List<Exercicio> exercicioList, String data) {
        this.userId = userId;
        this.exercicioList = exercicioList;
        this.data = data;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Exercicio> getExercicioList() {
        return exercicioList;
    }

    public void setExercicioList(List<Exercicio> exercicioList) {
        this.exercicioList = exercicioList;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
