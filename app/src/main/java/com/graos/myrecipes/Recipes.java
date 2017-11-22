package com.graos.myrecipes;

public class Recipes {
    private String name;
    private int numOfRecipes;
    private int imgDrawable;

    public Recipes(String name, int numOfRecipes, int imgDrawable) {
        this.name = name;
        this.numOfRecipes = numOfRecipes;
        this.imgDrawable = imgDrawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfRecipes() {
        return numOfRecipes;
    }

    public void setNumOfRecipes(int numOfRecipes) {
        this.numOfRecipes = numOfRecipes;
    }

    public int getImgDrawable() {
        return imgDrawable;
    }

    public void setImgDrawable(int imgDrawable) {
        this.imgDrawable = imgDrawable;
    }
}
