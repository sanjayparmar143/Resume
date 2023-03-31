package com.example.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class tem1 extends AppCompatActivity {

    SharedPreferences preferences;
    TextView txtName,editaddress,editemail,editphone,edithobby,editschool,editcourse,editgrade,edityear,editCompany,editjob,editDesciription,editJobyear,editskill1,editskill2,editskill3,editskill4,editgithub,editlinkedin,editobjective,editcompanyname,editcompanylink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tem1);

        preferences = getSharedPreferences("Data",0);

        txtName = findViewById(R.id.name);
        editaddress = findViewById(R.id.editaddress);
        editemail = findViewById(R.id.editemail);
        editphone = findViewById(R.id.editphone);
        edithobby = findViewById(R.id.edithobby);
        editschool = findViewById(R.id.editschool);
        editcourse = findViewById(R.id.editcourse);
        editgrade = findViewById(R.id.editgrade);
        edityear = findViewById(R.id.edityear);
        editCompany = findViewById(R.id.editCompany);
        editjob = findViewById(R.id.editjob);
        editDesciription = findViewById(R.id.editDesciription);
        editJobyear = findViewById(R.id.editJobyear);
        editskill1 = findViewById(R.id.editskill1);
        editskill2 = findViewById(R.id.editskill2);
        editskill3 = findViewById(R.id.editskill3);
        editskill4 = findViewById(R.id.editskill4);
        editlinkedin = findViewById(R.id.editlinkedin);
        editgithub = findViewById(R.id.editgithub);
        editobjective = findViewById(R.id.editobjective);
        editcompanyname = findViewById(R.id.editcompanyname);
        editcompanylink = findViewById(R.id.editcompanylink);

        String n1 = preferences.getString("name","");
        String n2 = preferences.getString("address","");
        String n3 = preferences.getString("email","");
        String n4 = preferences.getString("phone","");
        String n5 = preferences.getString("hobby","");
        String n6 = preferences.getString("course","");
        String n7 = preferences.getString("school","");
        String n8 = preferences.getString("grade","");
        String n9 = preferences.getString("year","");
        String n10 = preferences.getString("cname","");
        String n11 = preferences.getString("job","");
        String n12 = preferences.getString("desc","");
        String n13 = preferences.getString("yeare","");
        String n14 = preferences.getString("skill1","");
        String n15 = preferences.getString("skill2","");
        String n16 = preferences.getString("skill3","");
        String n17 = preferences.getString("skill4","");
        String n18 = preferences.getString("git","");
        String n19 = preferences.getString("link","");
        String n20 = preferences.getString("obj","");
        String n21 = preferences.getString("coname","");
        String n22 = preferences.getString("colink","");

        txtName.setText(n1);
        editaddress.setText(n2);
        editemail.setText(n3);
        editphone.setText(n4);
        edithobby.setText(n5);
        editschool.setText(n6);
        editcourse.setText(n7);
        editgrade.setText(n8);
        edityear.setText(n9);
        editCompany.setText(n10);
        editjob.setText(n11);
        editDesciription.setText(n12);
        editJobyear.setText(n13);
        editskill1.setText(n14);
        editskill2.setText(n15);
        editskill3.setText(n16);
        editskill4.setText(n17);
        editgithub.setText(n18);
        editlinkedin.setText(n19);
        editobjective.setText(n20);
        editcompanyname.setText(n21);
        editcompanylink.setText(n22);

    }
}