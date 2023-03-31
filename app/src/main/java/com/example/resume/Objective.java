package com.example.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Objective extends AppCompatActivity {


    EditText objective;
    Button next,reset;
    String obj;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objective);

        objective = findViewById(R.id.objective);
        next = findViewById(R.id.next);
        reset = findViewById(R.id.reset);

        preferences = getSharedPreferences("Data",0);
        editor = preferences.edit();

        reset.setOnClickListener(view -> objective.setText(""));

        next.setOnClickListener(view -> {

            obj = objective.getText().toString();

            if(obj.isEmpty()){
                objective.setError("Enter Objective!");
            }else{
                intent();

            }
            editor.putString("obj",obj);
            editor.commit();

        });
    }

    private void intent(){
        Intent intent = new Intent(Objective.this, Referance.class);
        finish();
        startActivity(intent);
    }
}