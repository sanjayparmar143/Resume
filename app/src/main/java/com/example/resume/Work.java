package com.example.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Work extends AppCompatActivity {
    String git,link;
    EditText github,Linkedin;
    Button reset,next;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        preferences = getSharedPreferences("Data",0);
        editor = preferences.edit();

        github = findViewById(R.id.github);
        Linkedin = findViewById(R.id.Linkedin);
        reset = findViewById(R.id.reset);
        next = findViewById(R.id.next);

        reset.setOnClickListener(view -> {

            github.setText("");
            Linkedin.setText("");
        });

        next.setOnClickListener(view -> {

            git = github.getText().toString();
            link = Linkedin.getText().toString();

            if(git.isEmpty()){
                github.setError("Enter link");
            } else if (link.isEmpty()) {
                Linkedin.setError("Enter link");
            } else if (!git.toLowerCase().contains(".com")) {
                github.setError("Enter valid link!");
            } else if (!link.toLowerCase().contains(".com")) {
                Linkedin.setError("Enter valid link!");

            } else{
                intent();
            }

            editor.putString("git",git);
            editor.putString("link",link);
            editor.commit();

        });

    }

    private void intent(){
        Intent intent = new Intent(Work.this, Objective.class);
        finish();
        startActivity(intent);
    }

}