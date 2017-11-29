package com.graos.myrecipes;

public class Recipes {
    private String name;
    private int imgDrawable;

    public Recipes(String name, int imgDrawable) {
        this.name = name;
        this.imgDrawable = imgDrawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgDrawable() {
        return imgDrawable;
    }

    public void setImgDrawable(int imgDrawable) {
        this.imgDrawable = imgDrawable;
    }
}
