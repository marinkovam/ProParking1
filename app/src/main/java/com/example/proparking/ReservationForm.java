package com.example.proparking;
import android.app.Fragment;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.Spinner;
        import android.widget.TimePicker;

        import androidx.appcompat.app.AppCompatActivity;

        import com.example.proparking.Parking_places;

        import java.util.ArrayList;
        import java.util.List;

public class ReservationForm extends AppCompatActivity {

    String city, username;
    String time;
    DatePicker simpleDatePicker;
    Button button;
    String selectedDate;
    int day, month, year;
    List<Parking_places> parkingList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_form);
        Fragment fragment1 = getFragmentManager().findFragmentById(R.id.fragment1);
        Fragment fragment2 = getFragmentManager().findFragmentById(R.id.fragment1);
        Intent intent = getIntent();
        city = intent.getStringExtra("city");
        username = Cities.getUsername();

        simpleDatePicker = (DatePicker) findViewById(R.id.datePicker);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.hours, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        day = simpleDatePicker.getDayOfMonth();
        month = simpleDatePicker.getMonth() + 1;
        year = simpleDatePicker.getYear();
        selectedDate = day + "/" + month + "/" + year;
        time = spinner.getSelectedItem().toString();

        button = (Button) findViewById(R.id.reserve);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ParkingPlaces.class);
                intent.putExtra("date", selectedDate);
                intent.putExtra("time", time);
                intent.putExtra("city", city);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }

    // private List<Parking_places> getAllParkingPlaces() {
    //  MyDatabase handler = new MyDatabase(ReservationForm.this);
    //return handler.getAllParkingPlaces(city);
    //}
    //private void ListParkingPlaces() {

    //   List<Parking_places> ParkingPlaces = getAllParkingPlaces();

    // AppCompatActivity activity = ReservationForm.this;
    // ParkingPlaces parking =
    //       new ParkingPlaces(ParkingPlaces);
    // }
}