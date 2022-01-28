package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyDietCustomAdapter extends ArrayAdapter<Mydiet> {

    private Context context;
    private int resource;

    public MyDietCustomAdapter(@NonNull Context  context , int resource , @NonNull List<Mydiet> objects){
        super(context ,resource , objects);
        this.context =context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view ==null)
            view= LayoutInflater.from(context).inflate(resource,parent , false);
        Mydiet mydiet=getItem(position);
        if(mydiet!=null){
             TextView textViewCalories =view.findViewById(R.id.TextViewCalories);
            TextView textViewProtien =view.findViewById(R.id.protienTextView);
            TextView textViewCarbs =view.findViewById(R.id.carbstextview);
            TextView textViewFats =view.findViewById(R.id.fatstextview);
            textViewCalories.setText("Calories Needed: "+mydiet.getCalories());
            textViewProtien.setText("Protien: "+mydiet.getProtein());
            textViewCarbs.setText("Carbs: "+mydiet.getCarbs());
            textViewFats.setText("Fats: "+mydiet.getFats());




        }
        return view;
    }
}
