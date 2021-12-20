package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class createDietActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //get instance of authentiacation priject firebase console
    private FirebaseAuth  maFirebaseAuth= FirebaseAuth.getInstance();
    //gets the root of the real time databasein the fb console
    private FirebaseDatabase database=FirebaseDatabase.getInstance("https://ahmad-71616-default-rtdb.europe-west1.firebasedatabase.app/");
    private String program;
    private EditText editTextHeight;
    private EditText editTextWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_diet);
        Spinner spinner=findViewById(R.id.spinner);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);


        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.goals , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseAuth  maFirebaseAuth= FirebaseAuth.getInstance();
        String UID=maFirebaseAuth.getUid();
        //build a ref for user related data in real time data base using user id
        DatabaseReference myRef = database.getReference("users/"+UID);
        // add an item to the firebase under the referenced specified
        myRef.push().setValue(new Meal("this is my first item ",7,true,50,100,25));
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Meal meal1=dataSnapshot.getValue(Meal.class);
               //     ArrayList.add(meal1);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void diet(View view ){
        Intent intent = new Intent(this, DietActivity.class);
        String weight = editTextWeight.getText().toString();
        String height = editTextHeight.getText().toString();
        String MyDiet= program;


        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        program= adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), "text", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}