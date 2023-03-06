package com.example.remedoc_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class search_docHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_doc_home);
    }

    public void openActivity(View v){
        Intent intent=new Intent(this,search_doc1.class);
        startActivity(intent);
    }

    public void openActivity2(View v){
        Intent intent=new Intent(this,search_doc2.class);
        startActivity(intent);
    }

    public void openActivity3(View v){
        Intent intent=new Intent(this,search_doc3.class);
        startActivity(intent);
    }

    public void openActivity4(View v){
        Intent intent=new Intent(this,search_doc4.class);
        startActivity(intent);
    }

    public void openActivity5(View v){
        Intent intent=new Intent(this,search_doc5.class);
        startActivity(intent);
    }
}