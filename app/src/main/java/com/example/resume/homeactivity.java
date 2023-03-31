package com.example.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class homeactivity extends AppCompatActivity {

    Button create,exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

        create = findViewById(R.id.create);
        exit = findViewById(R.id.exit);

        create.setOnClickListener(view -> {

            finish();
            Intent intent = new Intent(homeactivity.this,personalactivity.class);
            startActivity(intent);
        });

        exit.setOnClickListener(view -> finish());
    }
}