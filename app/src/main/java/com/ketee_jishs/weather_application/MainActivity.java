package com.ketee_jishs.weather_application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;
import com.ketee_jishs.weather_application.model.WeatherRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private ImageButton settingsButton;
    static FrameLayout addParamsLayout;

    static final String layoutVisibilityDataKey = "layoutVisibilityDataKey";

    private static final String TAG = "WEATHER";
    private static final String WEATHER_URL_FIRST = "https://api.openweathermap.org/data/2.5/forecast?q=";
    private static final String WEATHER_URL_SECOND = "&lang=";
    private static final String WEATHER_URL_THIRD = "&appid=";

    private static String cityName;
    static float kelvin = 273.15f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onStart() {
        super.onStart();
        findViews();
        forecast();
        final Animation animAlpha = AnimationUtils.loadAnimation(getBaseContext(), R.anim.alpha);
        settingsButton.setOnClickListener(v -> {
            settingsButton.startAnimation(animAlpha);
            onClickSettings();
        });
    }

    public void onClickSettings() {
        startActivity(new Intent(MainActivity.this, SettingsActivity.class));
    }

    private void findViews() {
        addParamsLayout = findViewById(R.id.addParamsLayout);
        settingsButton = findViewById(R.id.settingsButton);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void forecast() {
        try {
            cityName = ForecastForCityFragment.chosenCityView.getText().toString();
            Locale.setDefault(SetLanguageFragment.lang);
            final URL uri = new URL(WEATHER_URL_FIRST + cityName + WEATHER_URL_SECOND + Locale.getDefault() + WEATHER_URL_THIRD + BuildConfig.WEATHER_API_KEY);
            final Handler handler = new Handler();

            new Thread(() -> {
                HttpsURLConnection urlConnection = null;
                try {
                    urlConnection = (HttpsURLConnection) uri.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setReadTimeout(10000);
                    BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    String result = getLines(in);

                    Gson gson = new Gson();
                    final WeatherRequest weatherRequest = gson.fromJson(result, WeatherRequest.class);
                    handler.post(() -> displayWeather(weatherRequest));

                } catch (Exception e) {
                    Log.e(TAG, "Fail connection", e);
                    e.printStackTrace();
                } finally {
                    if (null != urlConnection) {
                        urlConnection.disconnect();
                    }
                }
            }).start();
        } catch (MalformedURLException e) {
            Log.e(TAG, "Fail URI", e);
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private String getLines(BufferedReader in) {
        return in.lines().collect(Collectors.joining("\n"));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("DefaultLocale")
    private void displayWeather(WeatherRequest weatherRequest) {
        String temperatureValue = String.format("%.0f", weatherRequest.list.get(0).main.getTemp() - kelvin);
        tempType(temperatureValue);
        TemperatureFragment.dayTempView.setText(temperatureValue);

        String feelsLikeValue = String.format("%.0f", weatherRequest.list.get(0).main.getFeelsLike() - kelvin);
        tempType(feelsLikeValue);
        TemperatureFragment.feelsLikeTempView.setText(feelsLikeValue);

        String minValue = String.format("%.0f", weatherRequest.list.get(0).main.getTempMin() - kelvin);
        tempType(minValue);
        TemperatureFragment.minTempView.setText(minValue);

        String maxValue = String.format("%.0f", weatherRequest.list.get(0).main.getTempMax() - kelvin);
        tempType(maxValue);
        TemperatureFragment.maxTempView.setText(maxValue);

        String atmPressureValue = String.format("%d", weatherRequest.list.get(0).main.getPressure());
        AdditionalParametersFragment.atmospherePressureInfoView.setText(atmPressureValue);

        String humidityValue = String.format("%d", weatherRequest.list.get(0).main.getHumidity());
        AdditionalParametersFragment.humidityInfoView.setText(humidityValue);

        String windSpeedValue = String.format("%.0f", weatherRequest.list.get(0).wind.getSpeed());
        AdditionalParametersFragment.windSpeedInfoView.setText(windSpeedValue);

        String dateValue = ConvertToDay.convertUnixToFullDate(weatherRequest.list.get(0).dt);
        TemperatureFragment.dateTimeView.setText(dateValue);

        String descr = weatherRequest.list.get(0).weather.get(0).getDescription();
        String description = descr.substring(0, 1).toUpperCase() + descr.substring(1);
        TemperatureFragment.descriptionView.setText(description);

        String todayDW = String.format("%.0f", weatherRequest.list.get(0).main.getTemp() - kelvin);
        tempType(todayDW);
        WeatherFiveDaysFragment.degrDayOneView.setText(todayDW);

        String tomorrowDW = String.format("%.0f", weatherRequest.list.get(8).main.getTemp() - kelvin);
        tempType(tomorrowDW);
        WeatherFiveDaysFragment.degrDayTwoView.setText(tomorrowDW);

        String tuesdayDW = String.format("%.0f", weatherRequest.list.get(16).main.getTemp() - kelvin);
        tempType(tuesdayDW);
        WeatherFiveDaysFragment.degrDayThreeView.setText(tuesdayDW);

        String wednesdayDW = String.format("%.0f", weatherRequest.list.get(24).main.getTemp() - kelvin);
        tempType(wednesdayDW);
        WeatherFiveDaysFragment.degrDayFourView.setText(wednesdayDW);

        String thursdayDW = String.format("%.0f", weatherRequest.list.get(32).main.getTemp() - kelvin);
        tempType(thursdayDW);
        WeatherFiveDaysFragment.degrDayFiveView.setText(thursdayDW);

        String dayOne = getResources().getString(R.string.today);
        WeatherFiveDaysFragment.dayOneView.setText(dayOne);

        String dayTwo = getResources().getString(R.string.tomorrow);
        WeatherFiveDaysFragment.dayTwoView.setText(dayTwo);

        String dayThird = String.format(ConvertToDay.convertUnixToDay(weatherRequest.list.get(16).dt));
        String dayThree = dayThird.substring(0, 1).toUpperCase() + dayThird.substring(1);
        WeatherFiveDaysFragment.dayThreeView.setText(dayThree);

        String dayForth = String.format(ConvertToDay.convertUnixToDay(weatherRequest.list.get(24).dt));
        String dayFour = dayForth.substring(0, 1).toUpperCase() + dayForth.substring(1);
        WeatherFiveDaysFragment.dayFourView.setText(dayFour);

        String dayFifth = String.format(ConvertToDay.convertUnixToDay(weatherRequest.list.get(32).dt));
        String dayFive = dayFifth.substring(0, 1).toUpperCase() + dayFifth.substring(1);
        WeatherFiveDaysFragment.dayFiveView.setText(dayFive);

        WeatherFiveDaysFragment.descriptionOne.setText(descr);

        String descriptionTwo = weatherRequest.list.get(8).weather.get(0).getDescription();
        WeatherFiveDaysFragment.descriptionTwo.setText(descriptionTwo);

        String descriptionThree = weatherRequest.list.get(16).weather.get(0).getDescription();
        WeatherFiveDaysFragment.descriptionThree.setText(descriptionThree);

        String descriptionFour = weatherRequest.list.get(24).weather.get(0).getDescription();
        WeatherFiveDaysFragment.descriptionFour.setText(descriptionFour);

        String descriptionFive = weatherRequest.list.get(32).weather.get(0).getDescription();
        WeatherFiveDaysFragment.descriptionFive.setText(descriptionFive);
    }

    private String tempType(String temp) {
        StringBuffer stringBuffer = new StringBuffer(temp);
        if (temp.equals("-0")) {
            stringBuffer.deleteCharAt(0);
            temp = stringBuffer.toString();
        }
        return temp;
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