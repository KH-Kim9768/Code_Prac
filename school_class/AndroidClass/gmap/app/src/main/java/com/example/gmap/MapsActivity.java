package com.example.gmap;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    UiSettings opt;
    EditText lat, lon, intext;
    Button show;
    View.OnClickListener cl;
    double d1, d2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        lat = (EditText) findViewById(R.id.latitude);
        lon = (EditText) findViewById(R.id.longitude);
        intext = (EditText) findViewById(R.id.inputtext);
        show = (Button) findViewById(R.id.show);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.show:
                        d1 = Double.parseDouble(lat.getText().toString());
                        d2 = Double.parseDouble(lon.getText().toString());


                        LatLng insert = new LatLng(d1, d2);
                        mMap.addMarker(new MarkerOptions().position(insert).title(intext.getText().toString()));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(insert));
                        mMap.moveCamera(CameraUpdateFactory.zoomTo(7));
                        break;
                }
            }
        };

        show.setOnClickListener(cl);
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

        opt = mMap.getUiSettings();
        opt.setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng seoul = new LatLng(37.1234, 126.9876);
        mMap.addMarker(new MarkerOptions().position(seoul).title("제가 찍은 위치입니다."));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seoul));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(14));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 101, 0, "일반");
        menu.add(0, 102, 0, "위성");
        menu.add(0, 103, 0, "하이브리드");
        menu.add(0, 104, 0, "지형");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 101 :
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;

            case 102:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;

            case 103:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;

            case 104:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}