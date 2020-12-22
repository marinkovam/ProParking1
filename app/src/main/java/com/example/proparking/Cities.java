package com.example.proparking;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class Cities extends AppCompatActivity {

    public static String username;
    RecyclerView mRecyclerView;
    MyAdapter mAdapter;
    int image_id[] ={R.drawable.skopje, R.drawable.bitola, R.drawable.tetovo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        List<String> values = Arrays.asList("Скопје", "Битола", "Тетово" );
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new MyAdapter(values, R.layout.activity_my_adapter, this, image_id);
        mRecyclerView.setAdapter(mAdapter);
    }
    public static String getUsername() {
        return username;
    }
}




