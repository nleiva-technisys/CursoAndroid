package com.seccion.nleiva.ejercicioseccion4.models;

public class Movie {

    private String name;
    private int image;

    public Movie(String n, int i){
        name=n;
        image=i;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
