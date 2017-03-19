package calkimchi.parkingmapsapplication;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


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

        // Add a marker in Sydney and move the camera
        LatLng test = new LatLng(37.727090, -122.482265);
        mMap.addMarker(new MarkerOptions().position(test).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(test,18)); //zoom lv is 1 to 20
    }

    // Record location method


    // Compare current to parking locations
    // Record street cleaning time and date
    // Send push notification

    /*
    public void sendNotification (View view){

        NotificationManager notificationmanagerobj = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intentobj = new Intent(this, resultpage.class);
        PendingIntent pinetntobj = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);


        NotificationCompat notificationobj = new NotificationCompat.Builder(this)
                //.setSmallIcon(R.drawable.ic_stat_name)
                .setContentTitle("Content Title")
                .setContentText("This is the content text")
                .setTicker("This is the ticker")
                .setContentIntent(pintentobj)
                .build();



        //Intent moreInfoIntent = new Intent(this, MoreInfoNotification.class) //This is navigates to the new window when notif is clcked on

        //TaskStackBuilder tStackBuilder = TaskStackBuilder.create(this);
        //tStackBuilder.addParentStack(MoreInfoNotification.class);
        //tStackBuilder.addNextIntent(moreInfoIntent)
        //Makes sure that pressing back button returns to whatever was occuring

        notificationmanagerobj.notify(0, notificationobj);
        }
    */
    //
}
