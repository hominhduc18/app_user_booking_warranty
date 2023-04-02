package com.example.userwarranty.map;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.example.userwarranty.R;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class Activity_map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Khởi tạo Configuration
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        setContentView(R.layout.activity_map);

        // Lấy reference đến MapView
        MapView map = findViewById(R.id.mapview);

        // Đặt map source
        map.setTileSource(TileSourceFactory.MAPNIK);

        // Đặt vị trí bản đồ hiển thị ban đầu
        GeoPoint startPoint = new GeoPoint(10.776384, 106.702808);


        Marker starMarker = new Marker(map);
        starMarker.setPosition(startPoint);


//        starMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER);để hiên bảng trên marker
        map.getOverlays().add(starMarker);
        map.getController().setCenter(startPoint);
        map.getController().setZoom(10);
    }
}
