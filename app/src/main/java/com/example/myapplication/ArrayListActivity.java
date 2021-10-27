package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArrayListActivity extends AppCompatActivity {
    private ListView myListView;
    private CustomAdapter myAdapter;
    private ArrayList<Meal> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);
        list = new ArrayList<>();
        list.add(new Meal("MAQLOBA",R.drawable.maqluba, true,50, 5000, 350));
        list.add(new Meal("MJADRA",R.drawable.mjadra, true,50, 5000, 350));
        list.add(new Meal("SALMON",R.drawable.salmon, true,50, 5000, 350));
        list.add(new Meal("STEAK",R.drawable.steak, true,50, 5000, 350));
        list.add(new Meal("CHEAKIN",R.drawable.cheaken, true,80, 5000, 350));
        myListView = findViewById(R.id.myListView);
        myAdapter = new CustomAdapter(this, R.layout.meals_row, list);
        myListView.setAdapter(myAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Item:"+list.get(i),Toast.LENGTH_LONG).show();
            }
        });
        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                myAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}