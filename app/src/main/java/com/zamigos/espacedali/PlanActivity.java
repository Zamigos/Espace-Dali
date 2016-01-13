package com.zamigos.espacedali;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class PlanActivity extends MainActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private final LatLng LOCATION_MUSEUM = new LatLng(48.895575, 2.387731);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_plan);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        /*mMap.addMarker(new MarkerOptions().position(new LatLng(48.895370, 2.386543)).title("Salle des sculptures").snippet("test").snippet("test"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(48.895737, 2.387292)).title("Salle des peintures").snippet("test"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(48.896101, 2.387986)).title("Salle  des tableaux").snippet("test"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(48.894917, 2.387496)).title("Salle des films").snippet("test"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(48.895482, 2.388727)).title("Salle des illustrations").snippet("test"));*/
        mMap.setMyLocationEnabled(true);

        addMarker(mMap, 48.895370, 2.386543, "Salle des sculptures", "test\ntest");
        /*addMarker(mMap, 48.895737, 2.387292, "Salle des peintures");
        addMarker(mMap, 48.896101, 2.387986, "Salle  des tableaux");
        addMarker(mMap, 48.894917, 2.387496, "Salle des films");
        addMarker(mMap, 48.895482, 2.388727, "Salle des illustrations");*/

        mMap.setInfoWindowAdapter(new PopupAdapter(getLayoutInflater()));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Log.v("TEST", "test");
                SharedPreferences preferences = getSharedPreferences("com.zamigos.espacedali", Context.MODE_PRIVATE);
                preferences.edit().putString("idTheme", "1").commit();
                switch (marker.getTitle()){
                    case "Salle des sculptures":
                        preferences.edit().putString("idTheme", "1").commit();
                        break;
                }
                Intent intent = new Intent(PlanActivity.this, OeuvreActivity.class);
                startActivity(intent);
            }
        });

        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_MUSEUM, 17);
        mMap.animateCamera(update);
    }

    private void addMarker(GoogleMap map, double lat, double lon,
                           String title, String snippet) {
        map.addMarker(new MarkerOptions().position(new LatLng(lat, lon))
                .title(title)
                .snippet(snippet));
    }
}
