package com.example.myapplication;

public class Meal {
    private String description;
    private int resid;//image id to be loaded
    private int calories;
    private int protein;
    public Meal(){

    }

    public Meal(String description, int resid,int calories, int protein) {
        this.description = description;
        this.resid = resid;
        this.calories = calories;
        this.protein = protein;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }




    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }
}
