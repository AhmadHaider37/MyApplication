package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener  {
    private static final String TAG = "FIREBASE";
    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin, signUpButton;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
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

        if (!editTextEmail.getText().toString().equals("")) {
           SharedPreferences sp= getSharedPreferences("setting",MODE_PRIVATE);
           SharedPreferences.Editor editor=sp.edit();         editor.putString("email",editTextEmail.getText().toString());
           editor.putString("password",editTextPassword.getText().toString());
            editor.commit();

            login(editTextEmail.getText().toString(), editTextPassword.getText().toString());

        }
    }

    @Override
    public boolean onLongClick(View view) {
        editTextEmail.setText("");
        editTextPassword.setText("");
        return true;
    }



   


    public void login(String email,String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i=new Intent(MainActivity.this,WelcomeActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    public void signup(View view) {
        Intent i=new Intent(MainActivity.this,signUpActivity.class);
        startActivity(i);
    }
    }

