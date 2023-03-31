package com.example.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Referance extends AppCompatActivity {

    EditText companyname,companylink;
    String coname,colink;
    Button reset,next;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referance);

        preferences = getSharedPreferences("Data",0);
        editor = preferences.edit();

        companyname = findViewById(R.id.companyname);
        companylink = findViewById(R.id.companylink);
        reset = findViewById(R.id.reset);
        next = findViewById(R.id.next);

        reset.setOnClickListener(view -> {

            companyname.setText("");
            companylink.setText("");
        });

        next.setOnClickListener(view -> {

            coname = companyname.getText().toString();
            colink = companylink.getText().toString();

            if(coname.isEmpty()){
                companyname.setError("Enter Company name!");
            } else if (colink.isEmpty()) {
                companylink.setError("Enter company link");
            }else {
                intent();
            }

            editor.putString("coname",coname);
            editor.putString("colink",colink);
            editor.commit();


        });
    }

    private void intent(){
        Intent intent = new Intent(Referance.this, Template.class);
        finish();
        startActivity(intent);
    }
}