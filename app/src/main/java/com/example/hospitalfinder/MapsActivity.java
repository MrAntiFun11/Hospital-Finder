package com.example.hospitalfinder;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

import java.util.Vector;
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{
    private GoogleMap mMap;
    MarkerOptions marker;
    LatLng centerlocation;
    Vector<MarkerOptions> markerOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        centerlocation = new LatLng(6.4,100.3);

        markerOptions = new Vector<>();

        markerOptions.add(new MarkerOptions().title("Klinik Kesihatan Kangar")
                .position(new LatLng(6.440076627592727,100.19045203999103))
                .snippet("Open Monday-Friday: 8am - 5pm")
        );
        markerOptions.add(new MarkerOptions().title("Klinik Kesihatan Kuala Perlis")
                .position(new LatLng(6.397649178456993,100.13421882883581))
                .snippet("Open Monday-Friday: 8am - 930pm")
        );
        markerOptions.add(new MarkerOptions().title("Arau Health Clinic")
                .position(new LatLng(6.432684532292921,100.27040381349255))
                .snippet("Open Monday-Friday: 8am - 5pm")
        );
        markerOptions.add(new MarkerOptions().title("KLINIK KESIHATAN BESERI")
                .position(new LatLng(6.514992629293337,100.2305856))
                .snippet("Open Monday-Friday: 8am - 5pm")
        );
        markerOptions.add(new MarkerOptions().title("Kampung Gial Health Clinic")
                .position(new LatLng(6.46503806976435,100.2733612))
                .snippet("Open Monday-Friday: 8am - 5pm")
        );
        markerOptions.add(new MarkerOptions().title("Kaki Bukit Health Clinic")
                .position(new LatLng(6.6428222362207325,100.21105134417907))
                .snippet("Open Monday-Friday: 8am - 5pm")
        );
        markerOptions.add(new MarkerOptions().title("Klinik Kesihatan Simpang Empat")
                .position(new LatLng(6.336836745479369,100.19165898650745))
                .snippet("Open Monday-Friday: 8am - 5pm")
        );
        markerOptions.add(new MarkerOptions().title("Klinik Desa Guar Nangka")
                .position(new LatLng(6.477489086259135,100.2880211))
                .snippet("Open Monday-Friday: 8am - 5pm")
        );
        markerOptions.add(new MarkerOptions().title("Klinik Desa Santan")
                .position(new LatLng(6.470535851884991,100.228))
                .snippet("Open Monday-Friday: 8am - 5pm")
        );
        markerOptions.add(new MarkerOptions().title("Klinik Desa Jejawi")
                .position(new LatLng(6.44575174747335,100.23796158650744))
                .snippet("Open Monday-Friday: 8am - 5pm")
        );

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
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        for (MarkerOptions mark: markerOptions) {
            mMap.addMarker(mark);
        }

        enableMyLocation();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerlocation,9));
    }
    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        } else {
            String perms[] = {"android.permission.ACCESS_FINE_LOCATION"};
            // Permission to access the location is missing. Show rationale and request permission
            ActivityCompat.requestPermissions(this, perms,200);
        }
    }

}
