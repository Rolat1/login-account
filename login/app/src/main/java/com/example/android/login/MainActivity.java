package com.example.android.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText emailEdt, passwordEdt;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEdt = findViewById(R.id.email);
        passwordEdt = findViewById(R.id.password);
        submitBtn = findViewById(R.id.submitButton);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if fields are valid
                if (isValidFields()){
                    //starting a new activity
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

    private boolean isValidFields() {
        if (!isValidEmail()){
            return false;
        }
        if (!isValidPassword()){
            return false;
        }
        return true;
    }

    private boolean isValidEmail() {
        String email = emailEdt.getText().toString().trim();
        if (email.isEmpty()){
            Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
            emailEdt.requestFocus();
            return false;
        }
        else if (email.length() < 4){
            Toast.makeText(this, "Email must be greater than 3 characters", Toast.LENGTH_SHORT).show();
            emailEdt.requestFocus();
            return false;
        }
        return true;
    }
    private boolean isValidPassword() {
        String password = passwordEdt.getText().toString().trim();
        if (password.isEmpty()){
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
            passwordEdt.requestFocus();
            return false;
        }
        else if (password.length() < 5){
            Toast.makeText(this, "password must be at least 5 characters", Toast.LENGTH_SHORT).show();
            passwordEdt.requestFocus();
            return false;
        }
        return true;
    }
}