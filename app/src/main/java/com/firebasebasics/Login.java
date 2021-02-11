package com.firebasebasics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    TextInputLayout email, pwd;
    ProgressBar bar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        email = findViewById(R.id.email_login);
        pwd = findViewById(R.id.pwd_login);
        bar = findViewById(R.id.progressBar3_login);
        mAuth = FirebaseAuth.getInstance();
    }

    public void signIn(View view) {
        bar.setVisibility(View.VISIBLE);
        String email = this.email.getEditText().getText().toString();
        String password = pwd.getEditText().getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            bar.setVisibility(View.INVISIBLE);
                            Intent intent = new Intent(Login.this, Dashboard.class);
                            intent.putExtra("email", mAuth.getCurrentUser().getEmail());
                            intent.putExtra("uid", mAuth.getCurrentUser().getUid());
                            startActivity(intent);
                        } else {
                            bar.setVisibility(View.INVISIBLE);
                            Login.this.email.getEditText().setText("");
                            pwd.getEditText().setText("");
                            Toast.makeText(getApplicationContext(), "Invalid email/password", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}
