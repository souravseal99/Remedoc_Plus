package com.example.remedoc_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class patient_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        Button loginBtn = findViewById(R.id.patientLoginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText phone = findViewById(R.id.patientLoginPhone);
                EditText pass = findViewById(R.id.patientLoginPassword);

                String userID = phone.getText().toString();
                String password = pass.getText().toString();

                if (userID.equals("8768068039") && password.equals("admin@123")){
                    SharedPreferences sharedPreferences = getSharedPreferences("loginData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", userID);
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();
                    // Start the Home activity
                    Intent in = new Intent(patient_login.this, Patient_Page.class);
                    startActivity(in);
                    finish();
                } else {
                Toast.makeText(patient_login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
            }
        });
    }
}