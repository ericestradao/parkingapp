package com.example.user.parkingreservation;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.example.user.parkingreservation.model.ParkingPojo;
import com.example.user.parkingreservation.presenter.Presenter;
import com.example.user.parkingreservation.view.ViewContract;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, ViewContract {

    private GoogleMap mMap;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        presenter = new Presenter(this);
        Intent intent=getIntent();
        double latitude = intent.getDoubleExtra("latitude", 31.662194);
        double longitude = intent.getDoubleExtra("longitude", -106.388117);

        presenter.getParkingLot(latitude,longitude);

        LatLng home = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(home).title("Home"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(home));
    }

    @Override
    public void findParkingLot(ParkingPojo parkingPojo) {

        LatLng lot = new LatLng(parkingPojo.getLat(), parkingPojo.getLng());
        mMap.addMarker(new MarkerOptions().position(lot).title(parkingPojo.getName()));

        LatLng lot2 = new LatLng(parkingPojo.getLat(), parkingPojo.getLng());
        mMap.addMarker(new MarkerOptions().position(lot2).title(parkingPojo.getName()));

        LatLng lot3 = new LatLng(parkingPojo.getLat(), parkingPojo.getLng());
        mMap.addMarker(new MarkerOptions().position(lot3).title(parkingPojo.getName()));

        LatLng lot4 = new LatLng(parkingPojo.getLat(), parkingPojo.getLng());
        mMap.addMarker(new MarkerOptions().position(lot4).title(parkingPojo.getName()));

        LatLng lot5 = new LatLng(parkingPojo.getLat(), parkingPojo.getLng());
        mMap.addMarker(new MarkerOptions().position(lot5).title(parkingPojo.getName()));
    }
}
