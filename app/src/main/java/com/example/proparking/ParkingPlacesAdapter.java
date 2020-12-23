package com.example.proparking;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proparking.Parking_places;

import java.util.ArrayList;
import java.util.List;

////setContentView(R.layout.activity_parking_places_adapter);

public class ParkingPlacesAdapter extends RecyclerView.Adapter<ParkingPlacesAdapter.ViewHolder> {
    private DBOpenHelper mDatabase;
    List<Parking_places> myList;
    private int rowLayout;
    private Context mContext;
    final String city;
    String date, time, username;

    @NonNull
    @Override
    public ParkingPlacesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_parking_places_adapter, parent, false);
        return new ParkingPlacesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ParkingPlacesAdapter.ViewHolder viewHolder, int i) {
        final Parking_places entry = myList.get(i);
        viewHolder.myName.setText(entry.getParkingName());
        viewHolder.first.setText(entry.getTaken());
        viewHolder.second.setText(entry.getFree());
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Confirm.class);
                intent.putExtra("parking", entry.getParkingName());
                intent.putExtra("city", entry.getCityName());
                intent.putExtra("latitude", entry.getLatitude());
                intent.putExtra("longitude", entry.getLongitude());
                mContext.startActivity(intent);
                // mDatabase.insertReservationDetails(username, city, date, time, entry.getParkingName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView myName;
        public Button button;
        public TextView first;
        public TextView second;


        public ViewHolder(View itemView) {
            super(itemView);
            myName = (TextView) itemView.findViewById(R.id.parking);
            button=(Button) itemView.findViewById(R.id.b);
            first=(TextView) itemView.findViewById(R.id.second);
            second=(TextView) itemView.findViewById(R.id.first);
        }
    }
    public ParkingPlacesAdapter(List<Parking_places> myList, int rowLayout, Context context, String city, String date, String time, String username) {
        this.myList = myList;
        this.rowLayout = rowLayout;
        this.mContext = context;
        this.city=city;
        this.date=date;
        this.time=time;
        this.username=username;
    }
}