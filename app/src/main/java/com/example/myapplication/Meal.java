package com.example.myapplication;

public class Meal {
    private String description;
    private int resid;//image id to be loaded
    private boolean isHappy;
    private int amount;
    private int calories;
    private int protein;
    public Meal(){

    }

    public Meal(String description, int resid, boolean isHappy, int amount, int calories, int protein) {
        this.description = description;
        this.resid = resid;
        this.isHappy = isHappy;
        this.amount = amount;
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

    public boolean isHappy() {
        return isHappy;
    }

    public void setHappy(boolean happy) {
        isHappy = happy;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
