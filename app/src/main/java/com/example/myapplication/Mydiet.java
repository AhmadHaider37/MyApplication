package com.example.myapplication;

public class Mydiet {
    private String description;
    private boolean isHappy;
    private int amount;
    private int calories;
    private int protein;
    private int carbs;
    private int fats;

    public Mydiet(){

    }
    public Mydiet(String description,  boolean isHappy, int amount, int calories, int protein , int carbs , int fats) {
        this.description = description;
        this.isHappy = isHappy;
        this.amount = amount;
        this.calories = calories;
        this.protein = protein;
        this.carbs= carbs;
        this.fats=fats;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats=fats;
    }
}
