package com.eclite.map;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleActivity extends Activity implements MarkClickListener<RegionItem> {
    private MapView mMapView;
    private ClusterPresenterImpl presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        mMapView = (MapView) findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);
        presenter = new ClusterPresenterImpl(mMapView);
        presenter.setOnMarkerClickListener(SampleActivity.this);
    }

    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        //销毁资源
        presenter.onDestroy();
    }

    @Override
    public void onClick(@NotNull Marker marker, @NotNull List<? extends RegionItem> list) {

    }
}
