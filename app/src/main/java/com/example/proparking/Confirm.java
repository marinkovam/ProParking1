package com.example.proparking;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Confirm extends AppCompatActivity {
    public static String parking, city, latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

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
}