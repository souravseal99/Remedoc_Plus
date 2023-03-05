package com.example.remedoc_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Book_app2 extends AppCompatActivity {
    TextView doc_id,p_name,p_d,p_t;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_app2);

        doc_id=findViewById(R.id.doc_id);
        p_name=findViewById(R.id.p_name);
        p_d=findViewById(R.id.app_date);
        p_t=findViewById(R.id.app_time);

        Intent intent=getIntent();
       String doctor_id=intent.getStringExtra("key_id");
       String patient_name=intent.getStringExtra("key_name");
        String prefered_date=getIntent().getStringExtra("key_date");
        String prefered_time=getIntent().getStringExtra("key_time");

       doc_id.setText(doctor_id);
       p_name.setText(patient_name);
        p_d.setText(prefered_date);
        p_t.setText(prefered_time);

    }
}