package com.example.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Skill extends AppCompatActivity {

    Button reset,next;
    EditText skill1,skill2,skill3,skill4;
    String skil1,skil2,skil3,skil4;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);

        preferences = getSharedPreferences("Data",0);
        editor = preferences.edit();

        skill1 = findViewById(R.id.skill1);
        skill2 = findViewById(R.id.skill2);
        skill3 = findViewById(R.id.skill3);
        skill4 = findViewById(R.id.skill4);
        reset = findViewById(R.id.reset);
        next = findViewById(R.id.next);

        reset.setOnClickListener(view -> {
            skill1.setText("");
            skill2.setText("");
            skill3.setText("");
            skill4.setText("");
        });

        next.setOnClickListener(view -> {

            skil1 = skill1.getText().toString();
            skil2 = skill2.getText().toString();
            skil3 = skill3.getText().toString();
            skil4 = skill4.getText().toString();

            if(skil1.isEmpty()){
                skill1.setError("Enter Skill!");
            }
            else if(skil2.isEmpty()){
                skill2.setError("Enter Skill!");
            }
            else if(skil3.isEmpty()){
                skill3.setError("Enter Skill!");
            }
            else if(skil4.isEmpty()){
                skill4.setError("Enter Skill!");
            }else{
                intent();
            }

            editor.putString("skill1",skil1);
            editor.putString("skill2",skil2);
            editor.putString("skill3",skil3);
            editor.putString("skill4",skil4);
            editor.commit();
        });

    }

    private void intent(){
        Intent intent = new Intent(Skill.this, Work.class);
        finish();
        startActivity(intent);
    }
}