package com.example.remedoc_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Patient_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_page);
    }
    public void book_app(View v){
        Intent intent=new Intent(this,Book_app1.class);
        startActivity(intent);
    }
}