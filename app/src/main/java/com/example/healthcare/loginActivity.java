package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    EditText edUsername, edPassword;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.editTextAppAddress);
        edPassword = findViewById(R.id.regConfirmPassword);
        btn = findViewById(R.id.buttonCartCheckOut);
        tv = findViewById(R.id.loginPage);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                Database db = new Database(getApplicationContext(), "healthCare", null,  1); //creating a database object
                if(username.length()==0)
                {
                    Toast.makeText(getApplicationContext(), "Please enter your username", Toast.LENGTH_LONG).show();
                }
               else if(password.length()==0)
                {
                    Toast.makeText(getApplicationContext(), "Please enter the password", Toast.LENGTH_LONG).show();
                }
               else{
                   if(db.login(username,password)==1) {
                       Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                       SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                       SharedPreferences.Editor editor = sharedPreferences.edit();
                       editor.putString("username", username);
                       //to save our data with key and value
                       editor.apply();
                       startActivity(new Intent(loginActivity.this, homeActivity.class)); //if login success then redirect to home page
                   }
                   else{
                       Toast.makeText(getApplicationContext(), "Invalid username and password", Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating a new intent to call another explict(user defined activity) to jump to another page

                startActivity(new Intent(loginActivity.this, registerActivity.class));
            }
        });
    }
}