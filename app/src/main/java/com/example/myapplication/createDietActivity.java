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
import java.util.Date;
import java.util.List;

public class createDietActivity extends AppCompatActivity{
    //get instance of authentiacation priject firebase console
    private FirebaseAuth  maFirebaseAuth= FirebaseAuth.getInstance();
    //gets the root of the real time databasein the fb console
    private FirebaseDatabase database=FirebaseDatabase.getInstance("https://ahmad-71616-default-rtdb.europe-west1.firebasedatabase.app/");
    private String program;
    private EditText editTextHeight;
    private EditText editTextWeight;
    private ArrayList<Meal> meals=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_diet);


        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);




    }
    public void diet(View view ){
        Intent intent = new Intent(this, DietActivity.class);
        String weight = editTextWeight.getText().toString();
        String height = editTextHeight.getText().toString();
        double weightVal = Double.parseDouble(weight);
        double heightVal = Double.parseDouble(height);
        intent.putExtra("weight", weightVal);
        intent.putExtra("height", heightVal);
        FirebaseAuth  maFirebaseAuth= FirebaseAuth.getInstance();
        String UID=maFirebaseAuth.getUid();
        //build a ref for user related data in real time data base using user id
        DatabaseReference myRef = database.getReference("users/"+UID);
        // add an item to the firebase under the referenced specified


        myRef.push().setValue(new Mydiet((int)heightVal+(int)weightVal*30 , (int)weightVal*2 , (int)weightVal*4,(int)weightVal*1));

        startActivity(intent);
    }



}