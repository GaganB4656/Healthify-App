package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class healthArticleDetailsActivity extends AppCompatActivity {

    TextView tv;
    ImageView img;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article_details);

        btnBack = findViewById(R.id.buttonHADBack);
        img = findViewById(R.id.imageViewHAD);
        tv = findViewById(R.id.textViewHADTitle);

        Intent intent = getIntent();
        tv.setText(intent.getStringExtra("text1"));

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            int resId = bundle.getInt("text2");
            img.setImageResource(resId);
        }

        btnBack = findViewById(R.id.buttonHADBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(healthArticleDetailsActivity.this, healthArticleActivity.class));
            }
        });
    }
}