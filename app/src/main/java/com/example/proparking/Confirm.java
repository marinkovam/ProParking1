package com.example.proparking;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Confirm extends AppCompatActivity {
    public static String parking, city, latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        parking = intent.getStringExtra("parking");
        city = intent.getStringExtra("city");
        latitude = intent.getStringExtra("latitude");
        longitude = intent.getStringExtra("longitude");
    }
    public static String getParkingName() {
        return parking;
    }
    public static String getCityName(){ return city;}
    public static String getLat() {
        return latitude;
    }
    public static String getLong() {
        return longitude;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }
}