package com.example.jesus.kendotrannig.model;

import java.util.Date;
import java.util.List;

public class Treino {
    private String userId;
    private List<Exercicio> exercicioList;
    private Date data;

    public Treino() {
    }

    public Treino(String userId, List<Exercicio> exercicioList) {
        this.userId = userId;
        this.exercicioList = exercicioList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Exercicio> getExercicioList() {
        return exercicioList;
    }

    public void setExercicioList(List<Exercicio> exercicioList) {
        this.exercicioList = exercicioList;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
