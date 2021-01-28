package com.ketee_jishs.weather_application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ItemWeatherSource sourceData;
    private RecyclerView recViewWeather;
    private RecViewWeatherDataAdapter adapter;
    private ImageButton settingsButton;
    private ImageButton aboutMainButton;
    static FrameLayout addParamsLayout;

    private CoordinatorLayout coordLayoutMain;
    private FloatingActionButton floatingButtonMain;

    static final String layoutVisibilityDataKey = "layoutVisibilityDataKey";
    private final int choseCityActivityRequestCode = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        findViews();
        setupRecycledView(sourceData.build());
//        final Animation animAlpha = AnimationUtils.loadAnimation(getBaseContext(), R.anim.alpha);
//        settingsButton.setOnClickListener(v -> {
//            settingsButton.startAnimation(animAlpha);
//            onClickSettings();
//        });

        floatingButtonMain.setOnClickListener(this);
        settingsButton.setOnClickListener(this);
        aboutMainButton.setOnClickListener(this);
        ForecastForCityFragment.cityButton.setOnClickListener(this);
        TemperatureFragment.weekWeatherButton.setOnClickListener(this);
    }

//    public void onClickSettings() {
//        startActivity(new Intent(MainActivity.this, SettingsActivity.class));
//    }

    private void findViews() {
        sourceData = new ItemWeatherSource(getResources());
        recViewWeather = findViewById(R.id.recViewWeather);
        addParamsLayout = findViewById(R.id.addParamsLayout);
        settingsButton = findViewById(R.id.settingsButton);
        aboutMainButton = findViewById(R.id.aboutMainButton);

        coordLayoutMain = findViewById(R.id.coordLayoutMain);
        floatingButtonMain = findViewById(R.id.floatingButtonMain);

    }

    private void setupRecycledView(ItemWeatherSource sourceData) {
        recViewWeather.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL, false);
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

    @Override
    public void onClick(View view) {
        final Animation animAlpha = AnimationUtils.loadAnimation(getBaseContext(), R.anim.alpha);
        int id = view.getId();
        switch (id) {
            case R.id.settingsButton: {
                Snackbar snackbar = Snackbar
                        .make(coordLayoutMain, R.string.go_to_settings_screen, Snackbar.LENGTH_LONG)
                        .setAction(R.string.yes, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                settingsButton.startAnimation(animAlpha);
                                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                            }
                        });
                snackbar.show();
                break;
            }
            case R.id.aboutMainButton: {
                Snackbar snackbar = Snackbar
                        .make(coordLayoutMain, R.string.go_to_about_screen, Snackbar.LENGTH_LONG)
                        .setAction(R.string.yes, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                aboutMainButton.startAnimation(animAlpha);
                                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                            }
                        });
                snackbar.show();
                break;
            }
            case R.id.cityButton: {
                Snackbar snackbar = Snackbar
                        .make(coordLayoutMain, R.string.go_to_chose_city_screen, Snackbar.LENGTH_LONG)
                        .setAction(R.string.yes, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ForecastForCityFragment.cityButton.startAnimation(animAlpha);
                                Intent chosenCity = new Intent(MainActivity.this, ChoseCityActivity.class);
                                startActivityForResult(chosenCity, choseCityActivityRequestCode);
                            }
                        });
                snackbar.show();
                break;
            }
            case R.id.weekWeatherButton: {
                Snackbar snackbar = Snackbar
                        .make(coordLayoutMain, R.string.go_to_yandex_weather, Snackbar.LENGTH_LONG)
                        .setAction(R.string.yes, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                TemperatureFragment.weekWeatherUrlView.startAnimation(animAlpha);
                                Uri uri = Uri.parse(TemperatureFragment.weekWeatherUrlView.getText().toString());
                                Intent weekWeatherIntent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(weekWeatherIntent);
                            }
                        });
                snackbar.show();
                break;
            }
            case R.id.floatingButtonMain: {
                Snackbar snackbar = Snackbar
                        .make(coordLayoutMain, R.string.you_are_in_main, Snackbar.LENGTH_SHORT);
                snackbar.show();
                break;
            }
        }
    }
}