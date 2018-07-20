package com.example.jesus.kendotrannig.model;


import android.support.annotation.NonNull;

public class Exercicio implements Comparable<Exercicio> {
    private int Nivel;
    private String Descricao;
    private String Nome;
    private int GastoCalorico;
    private String Imagem;
    private int id;

    public Exercicio() {
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int nivel) {
        Nivel = nivel;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }


    public int getGastoCalorico() {
        return GastoCalorico;
    }

    public void setGastoCalorico(int gastoCalorico) {
        GastoCalorico = gastoCalorico;
    }

    public String getImagem() {
        return Imagem;
    }

    public void setImagem(String imagem) {
        Imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(@NonNull Exercicio exercicio) {
        return getNome().compareToIgnoreCase(exercicio.getNome());
    }
}
