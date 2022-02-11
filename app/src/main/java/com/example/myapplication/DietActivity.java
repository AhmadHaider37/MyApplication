package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DietActivity extends AppCompatActivity {
    private ListView myListView;
    private MyDietCustomAdapter myAdapter;
    private ArrayList<Mydiet> list;
    private FirebaseDatabase database=FirebaseDatabase.getInstance("https://ahmad-71616-default-rtdb.europe-west1.firebasedatabase.app/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);

        list = new ArrayList<>();

        //
        myListView = findViewById(R.id.myListView);

        FirebaseAuth maFirebaseAuth= FirebaseAuth.getInstance();
        String UID=maFirebaseAuth.getUid();
        //build a ref for user related data in real time data base using user id
        DatabaseReference myRef = database.getReference("users/"+UID);
        // add an item to the firebase under the referenced specified


        myAdapter = new MyDietCustomAdapter(this, R.layout.diet_row , list);
        myListView.setAdapter(myAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Mydiet mydiet=dataSnapshot.getValue(Mydiet.class);
                    list.add(mydiet);
                    myAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
     public void meals(View view) {
        Intent intent = new Intent(this, ArrayListActivity.class);
        startActivity(intent);

    }
}