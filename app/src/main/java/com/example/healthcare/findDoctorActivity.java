package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class findDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(findDoctorActivity.this, homeActivity.class));

            }
        });

        CardView familyPhysician = findViewById(R.id.cardFDFamilyPhysician);
        familyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent it =  new Intent(findDoctorActivity.this, doctorDetailsActivity.class);
             it.putExtra("title", "Family Physicians");
             startActivity(it);

            }
        });

        CardView dietician = findViewById(R.id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =  new Intent(findDoctorActivity.this, doctorDetailsActivity.class);
                it.putExtra("title", "Dietician");
                startActivity(it);

            }
        });

        CardView dentist = findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =  new Intent(findDoctorActivity.this, doctorDetailsActivity.class);
                it.putExtra("title", "Dentist");
                startActivity(it);

            }
        });

        CardView surgeon = findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =  new Intent(findDoctorActivity.this, doctorDetailsActivity.class);
                it.putExtra("title", "Surgeon");
                startActivity(it);

            }
        });

        CardView cardiologist = findViewById(R.id.cardFDCardiologist);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =  new Intent(findDoctorActivity.this, doctorDetailsActivity.class);
                it.putExtra("title", "Cardiologist");
                startActivity(it);

            }
        });
    }
}