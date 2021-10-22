package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin, signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextEmail = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        signUpButton = findViewById(R.id.buttonSignUp);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnLongClickListener(this);
        SharedPreferences sp= getSharedPreferences("setting",MODE_PRIVATE);
        String email = sp.getString("email", "");
        String password =sp.getString("password","");
        if (!email.equals("")&& !password.equals("")){
            editTextEmail.setText(email);
            editTextPassword.setText(password);

        }
    }

    public void login(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        if (!editTextEmail.getText().toString().equals("")) {
           SharedPreferences sp= getSharedPreferences("setting",MODE_PRIVATE);
           SharedPreferences.Editor editor=sp.edit();         editor.putString("email",editTextEmail.getText().toString());
           editor.putString("password",editTextPassword.getText().toString());
            editor.commit();
            intent.putExtra("name", editTextEmail.getText().toString());
            startActivity(intent);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        editTextEmail.setText("");
        editTextPassword.setText("");
        return true;
    }

    public void signUp(View view) {
        Intent intent = new Intent(this, signUpActivity.class);
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
            case R.id.settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show();
                break;
            case R.id.exit_menu:
                //closeApplication();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
