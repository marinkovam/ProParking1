package com.example.proparking;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class ConFragment1 extends Fragment {
    private static final int REQUEST_CODE_DETAILS_ACTIVITY = 1234;
    public ConFragment1() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_con1, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button button = (Button) getActivity().findViewById(R.id.navigate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCityLocation();
            }
        });
    }
    private void showCityLocation() {
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
            // show in same activity
            ConFragment2 frag = (ConFragment2) getFragmentManager().findFragmentById(R.id.fragment1);

        } else {
            Intent intent = new Intent(getActivity(), MapsActivity.class);
            startActivityForResult(intent, REQUEST_CODE_DETAILS_ACTIVITY);
        }
    }
}