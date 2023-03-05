package com.example.remedoc_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication102.MainActivity_102;

public class Patient_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_page);

        Button btn_searchDoc = findViewById(R.id.button4);

        btn_searchDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_Page.this, MainActivity_102.class);
                startActivity(i);
            }
        });
    }
}