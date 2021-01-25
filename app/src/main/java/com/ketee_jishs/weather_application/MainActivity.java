package com.ketee_jishs.weather_application;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    ItemWeatherSource sourceData;
    private RecyclerView recViewWeather;
    private RecViewWeatherDataAdapter adapter;
    static FrameLayout addParamsLayout;

    static final String layoutVisibilityDataKey = "layoutVisibilityDataKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        findViews();
        setupRecycledView(sourceData.build());
    }

    private void findViews() {
        sourceData = new ItemWeatherSource(getResources());
        recViewWeather = findViewById(R.id.recViewWeather);
        addParamsLayout = findViewById(R.id.addParamsLayout);
    }

    private void setupRecycledView(ItemWeatherSource sourceData) {
        recViewWeather.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recViewWeather.setLayoutManager(layoutManager);
        adapter = new RecViewWeatherDataAdapter(sourceData);
        recViewWeather.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        String layoutVisibility = String.valueOf(addParamsLayout.getVisibility());
        outState.putString(layoutVisibilityDataKey, layoutVisibility);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String layoutVisibility = savedInstanceState.getString(layoutVisibilityDataKey);
        addParamsLayout.setVisibility(Integer.parseInt(layoutVisibility));
    }
}