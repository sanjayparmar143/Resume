package com.example.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Experience extends AppCompatActivity {


    String company_name,job_title,description,year;
    EditText editcompanyName,editjob,editdescription,edityear;
    Button reset,next;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        preferences = getSharedPreferences("Data",0);
        editor = preferences.edit();

        editcompanyName = findViewById(R.id.editcompanyName);
        editjob = findViewById(R.id.editjob);
        editdescription = findViewById(R.id.editdescription);
        edityear = findViewById(R.id.edityear);
        reset = findViewById(R.id.reset);
        next = findViewById(R.id.next);

        reset.setOnClickListener(view -> {
            editcompanyName.setText("");
            editjob.setText("");
            editdescription.setText("");
            edityear.setText("");
        });

        next.setOnClickListener(view -> {
            company_name = editcompanyName.getText().toString();
            job_title = editjob.getText().toString();
            description = editdescription.getText().toString();
            year = edityear.getText().toString();

            if(company_name.isEmpty()){
                editcompanyName.setError("Enter Company name!");
            } else if (job_title.isEmpty()) {
                editjob.setError("Enter job");
            } else if (description.isEmpty()) {
                editdescription.setError("Enter Description");
            } else if (year.isEmpty()) {
                edityear.setError("Enter year");
            }else {
                intent();
            }

            editor.putString("cname",company_name);
            editor.putString("job",job_title);
            editor.putString("desc",description);
            editor.putString("yeare",year);
            editor.commit();

        });
    }
    private void intent(){
        Intent intent = new Intent(Experience.this, Skill.class);
        finish();
        startActivity(intent);
    }
}