package com.pura.model;

/**
 * Created by Manish-Pc on 20/02/2018.
 */

public class Contaminants {
    private String imagePath;

    public Contaminants() {
    }

    public Contaminants(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
