package com.example.remedoc_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create_acnt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acnt);

        Button btn = findViewById(R.id.signInBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etName = findViewById(R.id.PersonName);
                EditText etPassword = findViewById(R.id.newPassword);
                EditText etTele = findViewById(R.id.userTele);

                String name = etName.getText().toString();
                String tele = etTele.getText().toString();
                String password = etPassword.getText().toString();

                UserDataSource dataSource = new UserDataSource(getApplicationContext());
                dataSource.open();

                User user = dataSource.createUser(name, tele, password);
                System.out.println(user.name + " "+ user.tele + " " + user); //to debug
                dataSource.close();

                Toast.makeText(getApplicationContext(), "User created successfully", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Create_acnt.this, patient_login.class);
                startActivity(i);

            }
        });
    }


//    creating db
    public static class myDBHelper extends SQLiteOpenHelper {
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "users.db";
        private static final String TABLE_NAME = "users";
        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "name";
        private static final String COLUMN_TELE = "tele";
        private static final String COLUMN_PASSWORD = "password";

        public myDBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTable = "CREATE TABLE " + TABLE_NAME + " ( " +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_TELE + " TEXT," +
                    COLUMN_PASSWORD + " TEXT" +
                    " )";

            db.execSQL(createTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

    }

//    the user class to hold data
    public static class User {
        private int id;
        private String name;
        private String tele;
        private String password;

        public User(int id, String name, String tele, String password) {
            this.id = id;
            this.name = name;
            this.tele = tele;
            this.password = password;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTele() {
            return tele;
        }

        public void setTele(String tele) {
            this.tele = tele;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    //user Data source provider
    public static class UserDataSource {
        private SQLiteDatabase database;
        private myDBHelper myDbHelper;

        private String[] allColumns = {myDBHelper.COLUMN_ID,
                myDBHelper.COLUMN_NAME, myDBHelper.COLUMN_TELE, myDBHelper.COLUMN_PASSWORD};

        public UserDataSource(Context context) {
            myDbHelper = new myDBHelper((Context) context);
        }

        public void open() throws SQLException {
            database = myDbHelper.getWritableDatabase();
        }

        public void close() {
            myDbHelper.close();
        }

        public User createUser(String name, String tele, String password) {
            ContentValues values = new ContentValues();
            values.put(myDBHelper.COLUMN_NAME, name);
            values.put(myDBHelper.COLUMN_TELE, tele);
            values.put(myDBHelper.COLUMN_PASSWORD, password);

            long insertId = database.insert(myDBHelper.TABLE_NAME, null, values);

            Cursor cursor = database.query(myDBHelper.TABLE_NAME,
                    allColumns, myDBHelper.COLUMN_ID + " = " + insertId, null,
                    null, null, null);
            cursor.moveToFirst();
            User newUser = cursorToUser(cursor);
            cursor.close();

            return newUser;
        }

        private User cursorToUser(Cursor cursor) {
            int idIndex = cursor.getColumnIndex(myDBHelper.COLUMN_ID);
            int nameIndex = cursor.getColumnIndex(myDBHelper.COLUMN_NAME);
            int teleIndex = cursor.getColumnIndex(myDBHelper.COLUMN_TELE);
            int passwordIndex = cursor.getColumnIndex(myDBHelper.COLUMN_PASSWORD);

            int id = cursor.getInt(idIndex);
            String name = cursor.getString(nameIndex);
            String tele = cursor.getString(teleIndex);
            String password = cursor.getString(passwordIndex);

            return new User(id, name, tele, password);
        }

//        login function
        public User login(String tele, String password) {
            Cursor cursor = database.query(myDBHelper.TABLE_NAME,
                    allColumns, myDBHelper.COLUMN_TELE + " = ? AND " +
                            myDBHelper.COLUMN_PASSWORD + " = ?",
                    new String[] { tele, password },
                    null, null, null);

            cursor.moveToFirst();
            User user = null;
            if (!cursor.isAfterLast()) {
                user = cursorToUser(cursor);
            }
            cursor.close();
            return user;
        }
    }
}