package com.ketee_jishs.weather_application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    private final String dayTempDataKey = "dayTempDataKey";
    private final String nightTempDataKey = "nightTempDataKey";
    private final String atmospherePressureDataKey = "atmospherePressureDataKey";
    private final String windSpeedDataKey = "windSpeedDataKey";
    private final String humidityDataKey = "humidityDataKey";
    private final String chosenCityDataKey = "chosenCityDataKey";
    private final String weekWeatherDataKey = "weekWeatherDataKey";

    private final int choseCityActivityRequestCode = 15;

    private TextView dayDegreesView;
    private TextView nightDegreesView;
    private TextView atmospherePressureInfoView;
    private TextView windSpeedInfoView;
    private TextView humidityInfoView;
    private TextView chosenCityView;
    private TextView weekWeatherUrlView;

    private Button cityButton;
    private Button settingsButton;
    private Button weekWeatherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        cityButton.setOnClickListener(v -> {
            onClickSetCity(cityButton);
        });

        settingsButton.setOnClickListener(v -> {
            onClickSettings(settingsButton);
        });

        weekWeatherButton.setOnClickListener(v -> {
            onClickWeekWeather(weekWeatherButton);
        });
    }

    private void findViews() {
//        TextViews
        dayDegreesView = (TextView) findViewById(R.id.dayDegreesView);
        nightDegreesView = (TextView) findViewById(R.id.nightDegreesView);
        atmospherePressureInfoView = (TextView) findViewById(R.id.atmospherePressureInfoView);
        windSpeedInfoView = (TextView) findViewById(R.id.windSpeedInfoView);
        humidityInfoView = (TextView) findViewById(R.id.humidityInfoView);
        chosenCityView = (TextView) findViewById(R.id.chosenCityView);
        weekWeatherUrlView = (TextView) findViewById(R.id.weekWeatherUrlView);

//        Buttons
        settingsButton = (Button)findViewById(R.id.settingsButton);
        cityButton = (Button)findViewById(R.id.cityButton);
        weekWeatherButton =(Button)findViewById(R.id.weekWeatherButton);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        String dayTemp = dayDegreesView.getText().toString();
        outState.putString(dayTempDataKey, dayTemp);

        String nightTemp = nightDegreesView.getText().toString();
        outState.putString(nightTempDataKey, nightTemp);

        String atmospherePressure = atmospherePressureInfoView.getText().toString();
        outState.putString(atmospherePressureDataKey, atmospherePressure);

        String windSpeed = windSpeedInfoView.getText().toString();
        outState.putString(windSpeedDataKey, windSpeed);

        String humidity = humidityInfoView.getText().toString();
        outState.putString(humidityDataKey, humidity);

        String city = chosenCityView.getText().toString();
        outState.putString(chosenCityDataKey, city);

        String weekWeatherUrl = weekWeatherUrlView.getText().toString();
        outState.putString(weekWeatherDataKey, weekWeatherUrl);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String dayTemp = savedInstanceState.getString(dayTempDataKey);
        dayDegreesView.setText(dayTemp);

        String nightTemp = savedInstanceState.getString(nightTempDataKey);
        nightDegreesView.setText(nightTemp);

        String atmospherePressure = savedInstanceState.getString(atmospherePressureDataKey);
        atmospherePressureInfoView.setText(atmospherePressure);

        String windSpeed = savedInstanceState.getString(windSpeedDataKey);
        windSpeedInfoView.setText(windSpeed);

        String humidity = savedInstanceState.getString(humidityDataKey);
        humidityInfoView.setText(humidity);

        String city = savedInstanceState.getString(chosenCityDataKey);
        chosenCityView.setText(city);

        String weekWeatherUrl = savedInstanceState.getString(weekWeatherDataKey);
        weekWeatherUrlView.setText(weekWeatherUrl);
    }

    public void onClickSetCity(View view) {
        Intent chosenCity = new Intent(MainActivity.this, ChoseCityActivity.class);
        startActivityForResult(chosenCity, choseCityActivityRequestCode);
    }

    public void onClickSettings(View view) {
        startActivity(new Intent(MainActivity.this, SettingsActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == choseCityActivityRequestCode && resultCode == RESULT_OK) {
            chosenCityView.setText(data.getStringExtra(ChoseCityActivity.cityTextKey));
            dayDegreesView.setText(data.getStringExtra(ChoseCityActivity.dayTempTextKey));
            nightDegreesView.setText(data.getStringExtra(ChoseCityActivity.nightTempTextKey));
            atmospherePressureInfoView.setText(data.getStringExtra(ChoseCityActivity.atmospherePressureTextKey));
            windSpeedInfoView.setText(data.getStringExtra(ChoseCityActivity.windSpeedTextKey));
            humidityInfoView.setText(data.getStringExtra(ChoseCityActivity.humidityTextKey));
            weekWeatherUrlView.setText(data.getStringExtra(ChoseCityActivity.weekWeatherTextKey));
        }
    }

    public void onClickWeekWeather(View view) {
        Uri uri = Uri.parse(weekWeatherUrlView.getText().toString());
        Intent weekWeatherIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(weekWeatherIntent);
    }
}