package com.example.myapplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mydiet {
    private int calories;
    private int protein;
    private int carbs;
    private int fats;
    private String month;

    public Mydiet(){

    }
    public Mydiet( int calories, int protein , int carbs , int fats) {
        this.calories = calories;
        this.protein = protein;
        this.carbs= carbs;
        this.fats=fats;
        DateFormat dateFormat = new SimpleDateFormat("MM");
        Date date = new Date();
        this.month = dateFormat.format(date);
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
