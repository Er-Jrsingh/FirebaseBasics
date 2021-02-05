package com.firebasebasics;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebasebasics.Models.Users;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

TextView roll,name,course,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitted(View view) {

        roll =findViewById(R.id.roll);
        name =findViewById(R.id.name);
        course =findViewById(R.id.course);
        phone =findViewById(R.id.phone);

        String roll_no=roll.getText().toString().trim();
        String stu_name=name.getText().toString().trim();
        String course_name=course.getText().toString().trim();
        String phone_no=phone.getText().toString().trim();
        Users obj=new Users(stu_name,course_name,phone_no);

        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference node=db.getReference("Students");
        node.child(roll_no).setValue(obj);

        roll.setText("");
        name.setText("");
        course.setText("");
        phone.setText("");
        Toast.makeText(getApplicationContext(), "Data Insert Successful ", Toast.LENGTH_SHORT).show();

    }
}