package com.example.remedoc_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Patient_Page extends AppCompatActivity {

    ImageView book_Doc,search_doc;
        @SuppressLint("MissingInflatedId")
        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_patient_page);

            book_Doc = findViewById(R.id.book_app);
            search_doc = findViewById(R.id.searchdoc_btn);



            if (book_Doc != null) {
                book_Doc.setOnClickListener(view -> {
                    Intent i = new Intent(Patient_Page.this, Book_app1.class);
                    startActivity(i);
                });
            }

            if (search_doc != null) {
                search_doc.setOnClickListener(view -> {
                    Intent intent1 = new Intent(Patient_Page.this, search_docHome.class);
                    startActivity(intent1);
                });
            }
        }
}