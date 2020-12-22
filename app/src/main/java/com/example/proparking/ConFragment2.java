package com.example.proparking;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ConFragment2  extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    String parking, city, latitude, longitude;
    Float lat, lon;
    private LatLng myLocation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        parking=Confirm.getParkingName();
        city = Confirm.getCityName();
        latitude = Confirm.getLat();
        longitude = Confirm.getLong();
        lat =  Float.parseFloat(latitude);
        lon =  Float.parseFloat(longitude);

        View view = inflater.inflate(R.layout.fragment_con2, container, false);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        SupportMapFragment fragment = new SupportMapFragment();
        transaction.add(R.id.map, fragment);
        transaction.commit();

        fragment.getMapAsync(this);

        return view;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng selectedCity = new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(selectedCity).title("Marker in Selected Parking"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(selectedCity));
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT) {
            String navigationUri = "google.navigation:q=" + lat + "," + lon;
            Intent googleMapsNavigation = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(navigationUri));
            googleMapsNavigation.setPackage("com.google.android.apps.maps");
            startActivity(googleMapsNavigation);
        }
    }
}