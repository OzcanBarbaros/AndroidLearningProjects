package com.ozcan.moviebook;

import java.io.Serializable;

public class Movies implements Serializable {

    String name;
    String genre;
    int image;


    public Movies(String name, int image, String genre) {
        this.name = name;
        this.image = image;
        this.genre = genre;
    }
}
