package com.example.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Template extends AppCompatActivity {

    ImageView template;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        template = findViewById(R.id.template);

        template.setOnClickListener(view -> {
            Intent intent = new Intent(Template.this, tem1.class);
            finish();
            startActivity(intent);
        });
    }
}