package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {

    EditText edUsername, edPassword, edEmail, edConfirm;
    Button btn;
    TextView tv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextAppFullName);
        edEmail = findViewById(R.id.editTextAppAddress);
        edPassword = findViewById(R.id.editTextAppContactNumber);
        edConfirm = findViewById(R.id.regConfirmPassword);
        btn = findViewById(R.id.buttonCartCheckOut);
        tv = findViewById(R.id.loginPage);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating a new intent to call another explict(user defined activity)

                startActivity(new Intent(registerActivity.this, loginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                String email = edEmail.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db = new Database(getApplicationContext(), "healthCare", null,  1); //creating a database object

                if(username.length()==0 || password.length()==0 || email.length()==0 || confirm.length()==0)
                {
                    Toast.makeText(getApplicationContext(), "Please fill all the details", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.compareTo(confirm)==0)
                    {
                        if(isValid(password))
                        {   db.register(username, email, password); //a method on Database class to insert info into database
                            Toast.makeText(getApplicationContext(), "Registerd Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(registerActivity.this, loginActivity.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Password must contain atleast 8 characters having alpahbets, number and special symbol", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Password and confirm password didn't match", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
    public static  boolean isValid(String passwordhere)  //to check the validity of the password and return true if valid
    {
        int f1=0, f2=0, f3=0;
        if(passwordhere.length()<8){
            return  false;

        }
        else{
            for(int p=0; p<passwordhere.length(); p++){
                if(Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            for(int r=0; r<passwordhere.length(); r++){
                if(Character.isDigit(passwordhere.charAt(r)));
                {
                    f2=1;
                }
            }
            for(int s=0; s<passwordhere.length(); s++){
                char c = passwordhere.charAt(s);
                if(c>=33 && c<=46 || c==64)
                {
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;
        }
    }
}