package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DietActivity extends AppCompatActivity {
    private ListView myListView;
    private MyDietCustomAdapter myAdapter;
    private ArrayList<Mydiet> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);
        list = new ArrayList<>();
        list.add(new Mydiet("Your diet", true, 50, 5000, 350, 900,50));
        myListView = findViewById(R.id.myListView);
         myAdapter = new MyDietCustomAdapter(this, R.layout.diet_row , list);
        myListView.setAdapter(myAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
     public void meals(View view) {
        Intent intent = new Intent(this, ArrayListActivity.class);
     startActivity(intent);

    }
}
   // public void meals(View view) {
    //    Intent intent = new Intent(this, ArrayListActivity.class);
      //  startActivity(intent);

    //}


