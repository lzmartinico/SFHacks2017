package com.example.su_ange.gryft;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.su_ange.gryft.R.id.map;

public class DisplayMessageActivity extends FragmentActivity implements OnMapReadyCallback {

    private EditText currentPrice, potentialPrice;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();

        currentPrice = (EditText) findViewById(R.id.current);
        potentialPrice = (EditText) findViewById(R.id.potential);

        currentPrice.setText("30.15");
        potentialPrice.setText("15.85");
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng newyork = new LatLng(40.764246, -73.974924);
        mMap.addMarker(new MarkerOptions().position(newyork).title("New York City"));
        mMap.animateCamera(CameraUpdateFactory.zoomTo( 17.0f ));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(newyork));
    }
}
