package com.firebasebasics;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {
    TextView email, u_id;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        email = findViewById(R.id.email_home);
        u_id = findViewById(R.id.u_id);

        email.setText(getIntent().getStringExtra("email"));
        u_id.setText("UID :" + getIntent().getStringExtra("uid"));

    }

    public void logOut(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(Dashboard.this, MainActivity.class));
    }
}