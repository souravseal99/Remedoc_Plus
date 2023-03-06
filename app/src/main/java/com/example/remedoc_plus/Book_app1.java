package com.example.remedoc_plus;

import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Book_app1 extends AppCompatActivity {
 TextView pd,pt;
 Button btn;
 EditText d_id,p_name;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_app1);
        pd=findViewById(R.id.prefered_date);
        pt = findViewById(R.id.prefered_time);
        btn=findViewById(R.id.button);
        d_id=findViewById(R.id.editTextTextPersonName);
        p_name=findViewById(R.id.editTextTextPersonName2);

        final Calendar calendar=Calendar.getInstance();
        final int year= calendar.get(Calendar.YEAR);
        final int month= calendar.get(Calendar.MONTH);
        final int day= calendar.get(Calendar.DAY_OF_MONTH);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String doc_id=d_id.getText().toString();
                String patient_name=p_name.getText().toString();
                String prefered_date=pd.getText().toString();
                String prefered_time=pt.getText().toString();
                Toast.makeText(Book_app1.this, "Booking done successfully", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Book_app1.this,Book_app2.class);
                intent.putExtra("key_id",doc_id);
                intent.putExtra("key_name",patient_name);
                intent.putExtra("key_date",prefered_date);
                intent.putExtra("key_time",prefered_time);
                startActivity(intent);
            }
        });

        pd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog=new DatePickerDialog(Book_app1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                         Calendar c=Calendar.getInstance();
                         c.set(Calendar.YEAR,year);
                        c.set(Calendar.MONTH,month);
                        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                        String CurrentDateString= DateFormat.getDateInstance().format(c.getTime());
                        pd.setText(CurrentDateString);
                    }
                },year,month,day);
                dialog.show();
            }
        });

        pt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hours=calendar.get(Calendar.HOUR_OF_DAY);
                int min=calendar.get(Calendar.MINUTE);
                TimePickerDialog timepickerdialog=new TimePickerDialog(Book_app1.this, androidx.appcompat.R.style.Theme_AppCompat_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c=Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format=new SimpleDateFormat("k:mm a");
                        String Time=format.format(c.getTime());
                        pt.setText(Time);

                    }
                },hours,min,false);
                timepickerdialog.show();
            }
        });

    }

}