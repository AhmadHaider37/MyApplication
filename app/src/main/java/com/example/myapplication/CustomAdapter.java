package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Meal> {

    private Context context;
    private int resource;

    public CustomAdapter (@NonNull Context  context , int resource , @NonNull List<Meal> objects){
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
        Meal meal=getItem(position);
        if(meal!=null){
            ImageView imageView=view.findViewById(R.id.imageItem);
             TextView textViewDescription =view.findViewById(R.id.TextViewDesc);
           //  Button itemButton =view.findViewById(R.id.itemButton);
             imageView.setImageResource(meal.getResid());
             textViewDescription.setText(meal.getDescription());


        }
        return view;
    }
}
