package com.example.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class personalactivity extends AppCompatActivity {


    String name, email, phone, address;
    TextView hobby;
    EditText edtname, edtemail, edtphon, edtaddress;

    CheckBox music,reading,Gaming,travelling,other;
    Button reset, next;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalactivity);

        preferences = getSharedPreferences("Data",0);
        editor = preferences.edit();

        edtname = findViewById(R.id.edtname);
        edtaddress = findViewById(R.id.edtaddress);
        edtemail = findViewById(R.id.edtemail);
        edtphon = findViewById(R.id.edtphone);
        reset = findViewById(R.id.reset);
        next = findViewById(R.id.next);
        music = findViewById(R.id.music);
        reading = findViewById(R.id.reading);
        Gaming = findViewById(R.id.gaming);
        travelling = findViewById(R.id.travelling);
        other = findViewById(R.id.other);

        hobby = findViewById(R.id.hobby);

        reset.setOnClickListener(view -> {
            edtname.setText("");
            edtemail.setText("");
            edtaddress.setText("");
            edtphon.setText("");
        });

        next.setOnClickListener(view -> {

            name = edtname.getText().toString();
            address = edtaddress.getText().toString();
            email = edtemail.getText().toString();
            phone = edtphon.getText().toString();

            String Hobby = "";

            if (music.isChecked()) {
                Hobby += "music\n";
            }
            if (reading.isChecked()) {
                Hobby += "reading\n";
            }
            if (Gaming.isChecked()) {
                Hobby += "Gaming\n";
            }
            if (travelling.isChecked()) {
                Hobby += "travelling\n";
            }

            hobby.setText("" + Hobby);

            if(name.isEmpty()){
                edtname.setError("Enter name!");
            }
            else if(address.isEmpty()){

                edtaddress.setError("Enter Address!");

            }

            else if (email.isEmpty()){
                edtemail.setError("Enter email!");
            }

            else if (!email.toLowerCase().contains("@gmail.com")) {

                edtemail.setError("Invalid Email!");

            }
            else if(( (edtphon.length() >10)) || (edtphon.length() <10)){

                edtphon.setError("Invalid Mobile Number!");
            }

            else if(Hobby.isEmpty()){

                hobby.setError("Select hobby!");

            }else {

                intent();
            }

            editor.putString("name", name);
            editor.putString("address", address);
            editor.putString("email", email);
            editor.putString("phone", phone);
            editor.putString("hobby", Hobby);
            editor.commit();

        });
    }

    private void intent() {
        Intent intent = new Intent(personalactivity.this, Education.class);
        finish();
        startActivity(intent);
    }

}
