package com.example.remedoc_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Patient_Page extends AppCompatActivity {

    ImageView book_Doc;
        @SuppressLint("MissingInflatedId")
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_page);

         book_Doc = findViewById(R.id.book_doc);
      //  TextView tv=findViewById(R.id.userText);

     //   Intent intent=getIntent();
      //  String user_inputText=intent.getStringExtra("key_user_name");
      //  tv.setText(user_inputText);

        book_Doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Patient_Page.this, Book_app1.class);
                startActivity(i);
            }
        });
    }
}