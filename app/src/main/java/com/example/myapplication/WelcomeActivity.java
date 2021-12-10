package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity implements DialogInterface.OnClickListener{

    private TextView textViewWelcome;
    private Button button;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

          textViewWelcome = findViewById(R.id.textViewWelcome);
          button = findViewById(R.id.buttonLogin);

//          String name =getIntent().getStringExtra("name");
//          textViewWelcome.setText("welcome  "+name);
    }
    public void onBackPressed(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("are you sure ?");
        builder.setCancelable(false);
        builder.setPositiveButton("yes", this);
        builder.setNegativeButton("No", this);
        AlertDialog dialog =builder.create();
        dialog.show();

    }
    public void onClick(DialogInterface dialog , int which){
        if(which==dialog.BUTTON_POSITIVE)
        {
            super.onBackPressed();
            dialog.cancel();

        }
        if (which==dialog.BUTTON_NEGATIVE){
            dialog.cancel();
        }
    }
    public void creat(View view){
        Intent intent = new Intent( this, createDietActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Camera:
                Intent intent = new Intent( this, ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.exitbox:
                //closeApplication();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }



}