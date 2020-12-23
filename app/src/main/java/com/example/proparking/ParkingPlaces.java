package com.example.proparking;

import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.proparking.Parking_places;

        import java.util.ArrayList;
        import java.util.List;

public class ParkingPlaces  extends AppCompatActivity {
    List<Parking_places> parkingPlaces;

    SQLiteDatabase sql;
    DBOpenHelper db;
    String city, username;
    String time, date;
    RecyclerView mRecyclerView;
    ParkingPlacesAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_places);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new DBOpenHelper(getApplicationContext());
        sql = db.getWritableDatabase();

        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        city = intent.getStringExtra("city");
        time = intent.getStringExtra("time");
        date = intent.getStringExtra("date");

        parkingPlaces = getAllParkingPlaces();

        mRecyclerView = (RecyclerView) findViewById(R.id.parking_places);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new ParkingPlacesAdapter(parkingPlaces, R.layout.activity_parking_places_adapter, this, city, date, time, username);
        mRecyclerView.setAdapter(mAdapter);

    }
    private List<Parking_places> getAllParkingPlaces() {
        DBOpenHelper handler = new DBOpenHelper(ParkingPlaces.this);
        return handler.getAllParkingPlaces(city);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }
}