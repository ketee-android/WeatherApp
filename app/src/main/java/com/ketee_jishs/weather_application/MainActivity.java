package com.ketee_jishs.weather_application;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String dayTempDataKey = "dayTempDataKey";
    private final String nightTempDataKey = "nightTempDataKey";
//    private final String atmospherePressureDataKey = "atmospherePressureDataKey";
//    private final String windSpeedDataKey = "windSpeedDataKey";
//    private final String humidityDataKey = "humidityDataKey";

    private TextView dayDegreesView;
    private TextView nightDegreesView;
    private TextView atmospherePressureInfoView;
    private TextView windSpeedInfoView;
    private TextView humidityInfoView;

    private Button cityButton;
    private Button settingsButton;
    private Button windSpeedCounterButton;
    private Button humidityCounterButton;
    private Button pressureCounterButton;
    private Button nightTempCounterButton;
    private Button dayTempCounterButton;

    private AtmospherePressureDataContainer atmospherePressureDataContainer = AtmospherePressureDataContainer.getInstance();
    private WindSpeedDataContainer windSpeedDataContainer = WindSpeedDataContainer.getInstance();
    private HumidityDataContainer humidityDataContainer = HumidityDataContainer.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        ActionBar actionBar = getSupportActionBar();

        Toast.makeText(this, "onCreateMain", Toast.LENGTH_SHORT).show();
        Log.d("onCreate", "onCreateMain");

        cityButton.setOnClickListener(v -> {
            onClickSetCity(cityButton);
        });

        settingsButton.setOnClickListener(v -> {
            onClickSettings(settingsButton);
        });

        windSpeedCounterButton.setOnClickListener(v -> {
            onClickWind(windSpeedCounterButton);
        });

        humidityCounterButton.setOnClickListener(v -> {
            onClickHumidity(humidityCounterButton);
        });

        pressureCounterButton.setOnClickListener(v -> {
            onClickPressure(pressureCounterButton);
        });

        nightTempCounterButton.setOnClickListener(v -> {
            onClickNightTemp(nightTempCounterButton);
        });

        dayTempCounterButton.setOnClickListener(v -> {
            onClickDayTemp(dayTempCounterButton);
        });
    }

    private void findViews() {
//        TextViews
        dayDegreesView = (TextView) findViewById(R.id.dayDegreesView);
        cityButton = (Button)findViewById(R.id.cityButton);
        nightDegreesView = (TextView) findViewById(R.id.nightDegreesView);
        atmospherePressureInfoView = (TextView) findViewById(R.id.atmospherePressureInfoView);
        windSpeedInfoView = (TextView) findViewById(R.id.windSpeedInfoView);
        humidityInfoView = (TextView) findViewById(R.id.humidityInfoView);

//        Buttons
        settingsButton = (Button)findViewById(R.id.settingsButton);
        windSpeedCounterButton = (Button)findViewById(R.id.windSpeedCounterButton);
        humidityCounterButton = (Button)findViewById(R.id.humidityCounterButton);
        pressureCounterButton = (Button)findViewById(R.id.pressureCounterButton);
        nightTempCounterButton = (Button)findViewById(R.id.nightTempCounterButton);
        dayTempCounterButton = (Button)findViewById(R.id.dayTempCounterButton);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStartMain", Toast.LENGTH_SHORT).show();
        Log.d("onStart", "onStartMain");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResumeMain", Toast.LENGTH_SHORT).show();
        Log.d("onResume", "onResumeMain");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPauseMain", Toast.LENGTH_SHORT).show();
        Log.d("onPause", "onPauseMain");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStopMain", Toast.LENGTH_SHORT).show();
        Log.d("onStop", "onStopMain");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestartMain", Toast.LENGTH_SHORT).show();
        Log.d("onRestart", "onRestartMain");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroyMain", Toast.LENGTH_SHORT).show();
        Log.d("onDestroy", "onDestroyMain");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Toast.makeText(this, "onSaveInstanceStateMain", Toast.LENGTH_SHORT).show();
        Log.d("onSaveInstanceState", "onSaveInstanceStateMain");

        String dayTemp = dayDegreesView.getText().toString();
        outState.putString(dayTempDataKey, dayTemp);

        String nightTemp = nightDegreesView.getText().toString();
        outState.putString(nightTempDataKey, nightTemp);

        //Using Singleton
        String atmospherePressure = atmospherePressureInfoView.getText().toString();
        outState.putString(String.valueOf(atmospherePressureDataContainer), atmospherePressure);

        String windSpeed = windSpeedInfoView.getText().toString();
        outState.putString(String.valueOf(windSpeedDataContainer), windSpeed);

        String humidity = humidityInfoView.getText().toString();
        outState.putString(String.valueOf(humidityDataContainer), humidity);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Toast.makeText(this, "onRestoreInstanceStateMain", Toast.LENGTH_SHORT).show();
        Log.d("onSaveInstanceState", "onRestoreInstanceStateMain");

        String dayTemp = savedInstanceState.getString(dayTempDataKey);
        dayDegreesView.setText(dayTemp);

        String nightTemp = savedInstanceState.getString(nightTempDataKey);
        nightDegreesView.setText(nightTemp);

        //Using Singleton
        String atmospherePressure = savedInstanceState.getString(String.valueOf(atmospherePressureDataContainer));
        atmospherePressureInfoView.setText(atmospherePressure);

        String windSpeed = savedInstanceState.getString(String.valueOf(windSpeedDataContainer));
        windSpeedInfoView.setText(windSpeed);

        String humidity = savedInstanceState.getString(String.valueOf(humidityDataContainer));
        humidityInfoView.setText(humidity);
    }

    public void onClickSetCity(View view) {
        startActivity(new Intent(MainActivity.this, ChoseCityActivity.class));
    }

    public void onClickSettings(View view) {
        startActivity(new Intent(MainActivity.this, SettingsActivity.class));
    }

    public void onClickWind(View view) {
        int windCounter = Integer.parseInt(windSpeedInfoView.getText().toString());
        String newWindSpeed = String.valueOf(++windCounter);
        windSpeedInfoView.setText(newWindSpeed);
    }

    public void onClickHumidity(View view) {
        int humidityCounter = Integer.parseInt(humidityInfoView.getText().toString());
        String newHumidity = String.valueOf(++humidityCounter);
        humidityInfoView.setText(newHumidity);
    }

    public void onClickPressure(View view) {
        int pressureCounter = Integer.parseInt(atmospherePressureInfoView.getText().toString());
        String newPressure = String.valueOf(++pressureCounter);
        atmospherePressureInfoView.setText(newPressure);
    }

    public void onClickNightTemp(View view) {
        int nightDegrees = Integer.parseInt(nightDegreesView.getText().toString());
        String newNightTemp = String.valueOf(++nightDegrees);
        nightDegreesView.setText(newNightTemp);
    }

    public void onClickDayTemp(View view) {
        int dayDegrees = Integer.parseInt(dayDegreesView.getText().toString());
        String newDayTemp = String.valueOf(++dayDegrees);
        dayDegreesView.setText(newDayTemp);
    }
}