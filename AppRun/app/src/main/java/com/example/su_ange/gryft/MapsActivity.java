package com.example.su_ange.gryft;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private Button button;
    private EditText from, to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        button = (Button) findViewById(R.id.routeButton);
        from = (EditText) findViewById(R.id.typeFrom);
        to = (EditText) findViewById(R.id.typeTo);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        button.setOnClickListener(this);
    }

    // called when  user clicks button
    public void onClick(View v) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng newyork = new LatLng(40.693980, -73.986161);
        mMap.addMarker(new MarkerOptions().position(newyork).title("New York City"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(newyork));
    }
}
