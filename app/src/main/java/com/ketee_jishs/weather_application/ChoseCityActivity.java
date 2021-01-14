package com.ketee_jishs.weather_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChoseCityActivity extends AppCompatActivity{

    private Button okButtonChoseCity;
    private Spinner chooseCitySpinner;

    static String cityTextKey = "cityTexKey";
    static String dayTempTextKey = "positionTextKey";
    static String nightTempTextKey = "nightTempTextKey";
    static String atmospherePressureTextKey = "atmospherePressureTextKey";
    static String windSpeedTextKey = "windSpeedTextKey";
    static String humidityTextKey = "humidityTextKey";
    static String weekWeatherTextKey = "weekWeatherTextKey";
    static String cityPositionTextKey = "cityPositionTextKey";

    static ArrayList dayTempList = new ArrayList();
    static ArrayList nightTempList = new ArrayList();
    static ArrayList atmospherePressureList = new ArrayList();
    static ArrayList windSpeedList = new ArrayList();
    static ArrayList humidityList = new ArrayList();
    static ArrayList weekWeatherList = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_city);
        findViews();
        arrayListsForParams();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        okButtonChoseCity.setOnClickListener(v -> {
            onClickOkButtonChoseCity();
        });

        setAdapterChooseCity();
    }

    private void findViews() {
        okButtonChoseCity = (Button)findViewById(R.id.okButtonSetCity);
        chooseCitySpinner = (Spinner) findViewById(R.id.chooseCitySpinner);
    }

    public void onClickOkButtonChoseCity() {
        String city = chooseCitySpinner.getSelectedItem().toString();
        int position = chooseCitySpinner.getSelectedItemPosition();

        String dayTemperature = String.valueOf(dayTempList.get(position));
        String nightTemperature = String.valueOf(nightTempList.get(position));
        String atmospherePressure = String.valueOf(atmospherePressureList.get(position));
        String windSpeed = String.valueOf(windSpeedList.get(position));
        String humidity = String.valueOf(humidityList.get(position));
        String weekWeather = String.valueOf(weekWeatherList.get(position));

        Intent chosenParams = new Intent();

        chosenParams.putExtra(cityTextKey, city);
        chosenParams.putExtra(dayTempTextKey, dayTemperature);
        chosenParams.putExtra(nightTempTextKey, nightTemperature);
        chosenParams.putExtra(atmospherePressureTextKey, atmospherePressure);
        chosenParams.putExtra(windSpeedTextKey, windSpeed);
        chosenParams.putExtra(humidityTextKey, humidity);
        chosenParams.putExtra(weekWeatherTextKey, weekWeather);

        setResult(RESULT_OK, chosenParams);
        finish();
    }

    public void setAdapterChooseCity() {
        ArrayAdapter<?> citiesAdapter = ArrayAdapter.createFromResource(this, R.array.cities_array, android.R.layout.simple_spinner_item);
        chooseCitySpinner.setAdapter(citiesAdapter);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        String city = chooseCitySpinner.getSelectedItem().toString();
        int position = chooseCitySpinner.getSelectedItemPosition();

        String dayTemperature = String.valueOf(dayTempList.get(position));
        String nightTemperature = String.valueOf(nightTempList.get(position));
        String atmospherePressure = String.valueOf(atmospherePressureList.get(position));
        String windSpeed = String.valueOf(windSpeedList.get(position));
        String humidity = String.valueOf(humidityList.get(position));
        String weekWeather = String.valueOf(weekWeatherList.get(position));

        Intent chosenParams = new Intent();

        chosenParams.putExtra(cityTextKey, city);
        chosenParams.putExtra(dayTempTextKey, dayTemperature);
        chosenParams.putExtra(nightTempTextKey, nightTemperature);
        chosenParams.putExtra(atmospherePressureTextKey, atmospherePressure);
        chosenParams.putExtra(windSpeedTextKey, windSpeed);
        chosenParams.putExtra(humidityTextKey, humidity);
        chosenParams.putExtra(weekWeatherTextKey, weekWeather);

        setResult(RESULT_OK, chosenParams);
        finish();
        return true;
    }

    private void arrayListsForParams() {
        // Day temperature
        dayTempList.add("-11");        dayTempList.add("-2");
        dayTempList.add("-17");        dayTempList.add("-3");
        dayTempList.add("-25");        dayTempList.add("-13");
        dayTempList.add("-15");        dayTempList.add("-14");
        dayTempList.add("-6");         dayTempList.add("-19");
        dayTempList.add("-18");        dayTempList.add("-1");
        dayTempList.add("-7");         dayTempList.add("-22");
        dayTempList.add("-9");         dayTempList.add("-21");
        dayTempList.add("-12");        dayTempList.add("-10");
        dayTempList.add("-20");        dayTempList.add("-4");

        // Night temperature
        nightTempList.add("-15");        nightTempList.add("-6");
        nightTempList.add("-20");        nightTempList.add("-5");
        nightTempList.add("-27");        nightTempList.add("-19");
        nightTempList.add("-18");        nightTempList.add("-21");
        nightTempList.add("-9");         nightTempList.add("-25");
        nightTempList.add("-22");        nightTempList.add("-3");
        nightTempList.add("-10");        nightTempList.add("-27");
        nightTempList.add("-11");        nightTempList.add("-26");
        nightTempList.add("-16");        nightTempList.add("-12");
        nightTempList.add("-23");        nightTempList.add("-7");

        // Atmosphere pressure
        atmospherePressureList.add("751");        atmospherePressureList.add("762");
        atmospherePressureList.add("750");        atmospherePressureList.add("764");
        atmospherePressureList.add("749");        atmospherePressureList.add("754");
        atmospherePressureList.add("748");        atmospherePressureList.add("755");
        atmospherePressureList.add("751");        atmospherePressureList.add("748");
        atmospherePressureList.add("752");        atmospherePressureList.add("747");
        atmospherePressureList.add("758");        atmospherePressureList.add("742");
        atmospherePressureList.add("760");        atmospherePressureList.add("753");
        atmospherePressureList.add("751");        atmospherePressureList.add("762");
        atmospherePressureList.add("750");        atmospherePressureList.add("763");

        // Wind speed
        windSpeedList.add("2");        windSpeedList.add("2");
        windSpeedList.add("1");        windSpeedList.add("9");
        windSpeedList.add("5");        windSpeedList.add("3");
        windSpeedList.add("2");        windSpeedList.add("2");
        windSpeedList.add("0");        windSpeedList.add("0");
        windSpeedList.add("7");        windSpeedList.add("4");
        windSpeedList.add("3");        windSpeedList.add("5");
        windSpeedList.add("9");        windSpeedList.add("6");
        windSpeedList.add("2");        windSpeedList.add("7");
        windSpeedList.add("8");        windSpeedList.add("3");

        // Humidity
        humidityList.add("87");        humidityList.add("79");
        humidityList.add("82");        humidityList.add("76");
        humidityList.add("54");        humidityList.add("77");
        humidityList.add("86");        humidityList.add("78");
        humidityList.add("68");        humidityList.add("91");
        humidityList.add("84");        humidityList.add("93");
        humidityList.add("59");        humidityList.add("65");
        humidityList.add("82");        humidityList.add("62");
        humidityList.add("80");        humidityList.add("63");
        humidityList.add("87");        humidityList.add("52");

        // Weather for week (urls)
        weekWeatherList.add("https://yandex.ru/pogoda/Moscow");           weekWeatherList.add("https://yandex.ru/pogoda/Saint-petersburg");
        weekWeatherList.add("https://yandex.ru/pogoda/Anapa");            weekWeatherList.add("https://yandex.ru/pogoda/Vladivostok");
        weekWeatherList.add("https://yandex.ru/pogoda/Vladimir");         weekWeatherList.add("https://yandex.ru/pogoda/Volgograd");
        weekWeatherList.add("https://yandex.ru/pogoda/Voronezh");         weekWeatherList.add("https://yandex.ru/pogoda/Yekaterinburg");
        weekWeatherList.add("https://yandex.ru/pogoda/Kazan");            weekWeatherList.add("https://yandex.ru/pogoda/Kaliningrad");
        weekWeatherList.add("https://yandex.ru/pogoda/Nizhny-novgorod");  weekWeatherList.add("https://yandex.ru/pogoda/Novosibirsk");
        weekWeatherList.add("https://yandex.ru/pogoda/Sochi");            weekWeatherList.add("https://yandex.ru/pogoda/Omsk");
        weekWeatherList.add("https://yandex.ru/pogoda/Rostov-na-Donu");   weekWeatherList.add("https://yandex.ru/pogoda/Samara");
        weekWeatherList.add("https://yandex.ru/pogoda/Suzdal");           weekWeatherList.add("https://yandex.ru/pogoda/Tver");
        weekWeatherList.add("https://yandex.ru/pogoda/Ufa");              weekWeatherList.add("https://yandex.ru/pogoda/Yaroslavl");
    }
}