package com.example.proparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    EditText username;
    EditText password;
    EditText first_name;
    EditText last_name;
    EditText registration;
    EditText number;
    EditText username1;
    EditText password1;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database_check(v);
            }
        });

    }
    public void database_input(View view){
        first_name=(EditText) findViewById(R.id.first_name);
        last_name=(EditText) findViewById(R.id.last_name);

        username1=(EditText) findViewById(R.id.username1);
        password1=(EditText) findViewById(R.id.pass);
        if (first_name.getText().toString().trim().length() == 0 || last_name.getText().toString().trim().length() == 0 || username1.getText().toString().trim().length() == 0 || password1.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Пополнете ги сите полиња!", Toast.LENGTH_SHORT).show();
        } else {
            DBOpenHelper myDatabase=new DBOpenHelper(MainActivity.this);
            myDatabase.insertUserDetails(first_name.getText().toString().trim(), last_name.getText().toString().trim(),
                    username1.getText().toString().trim(), password1.getText().toString().trim());
            Toast.makeText(this, "Успешна регистрација", Toast.LENGTH_SHORT).show();
            //first_name.setText("");
        }
    }

    public void database_check(View view) {
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        if(username.getText().toString().trim().length() == 0 || password.getText().toString().trim().length() == 0){
            Toast.makeText(this, "Пополнете ги сите полиња", Toast.LENGTH_LONG).show();
        }
        else{
            DBOpenHelper myDatabase=new DBOpenHelper(MainActivity.this);
            if(myDatabase.checkUser(username.getText().toString().trim()
                    , password.getText().toString().trim())) {
                Intent intent = new Intent(this, Cities.class);
                intent.putExtra("user", username.toString());
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Погрешно внесени информации", Toast.LENGTH_LONG).show();
            }
        }
    }
}
