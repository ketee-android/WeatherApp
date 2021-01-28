package com.ketee_jishs.weather_application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class TemperatureFragment extends Fragment {
    private final String dayTempDataKey = "dayTempDataKey";
    private final String nightTempDataKey = "nightTempDataKey";
    private final String weekWeatherDataKey = "weekWeatherDataKey";

    private final String forecastTextViewDataKey = "forecastTextViewDataKey";
    private final String dayTempViewDataKey = "dayTempViewDataKey";
    private final String nightTempViewDataKey = "nightTempViewDataKey";
    private final String weekWeatherButtonDataKey = "weekWeatherButtonDataKey";

    static TextView dayDegreesView;
    static TextView nightDegreesView;
    static TextView weekWeatherUrlView;
    static MaterialButton weekWeatherButton;

    static TextView forecastTextView;
    static TextView dayTempView;
    static TextView nightTempView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_temperature, container, false);

        dayDegreesView = rootView.findViewById(R.id.dayDegreesView);
        nightDegreesView = rootView.findViewById(R.id.nightDegreesView);
        weekWeatherButton = rootView.findViewById(R.id.weekWeatherButton);
        weekWeatherUrlView = rootView.findViewById(R.id.weekWeatherUrlView);
        forecastTextView = rootView.findViewById(R.id.forecastTextView);
        dayTempView = rootView.findViewById(R.id.dayTempView);
        nightTempView = rootView.findViewById(R.id.nightTempView);

        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        String dayTemp = dayDegreesView.getText().toString();
        outState.putString(dayTempDataKey, dayTemp);

        String nightTemp = nightDegreesView.getText().toString();
        outState.putString(nightTempDataKey, nightTemp);

        String weekWeatherUrl = weekWeatherUrlView.getText().toString();
        outState.putString(weekWeatherDataKey, weekWeatherUrl);

        String textView = forecastTextView.getText().toString();
        outState.putString(forecastTextViewDataKey, textView);

        String dayView = dayTempView.getText().toString();
        outState.putString(dayTempViewDataKey, dayView);

        String nightView = nightTempView.getText().toString();
        outState.putString(nightTempViewDataKey, nightView);

        String buttonText = weekWeatherButton.getText().toString();
        outState.putString(weekWeatherButtonDataKey, buttonText);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            String dayTemp = savedInstanceState.getString(dayTempDataKey);
            dayDegreesView.setText(dayTemp);

            String nightTemp = savedInstanceState.getString(nightTempDataKey);
            nightDegreesView.setText(nightTemp);

            String weekWeatherUrl = savedInstanceState.getString(weekWeatherDataKey);
            weekWeatherUrlView.setText(weekWeatherUrl);

            String textView = savedInstanceState.getString(forecastTextViewDataKey);
            forecastTextView.setText(textView);

            String dayView = savedInstanceState.getString(dayTempViewDataKey);
            dayTempView.setText(dayView);

            String nightView = savedInstanceState.getString(nightTempViewDataKey);
            nightTempView.setText(nightView);

            String buttonText = savedInstanceState.getString(weekWeatherButtonDataKey);
            weekWeatherButton.setText(buttonText);
        }

//        final Animation animAlpha = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
//        weekWeatherButton.setOnClickListener(v -> {
//            weekWeatherButton.startAnimation(animAlpha);
//            onClickWeekWeather();
//        });
    }

    public void onClickWeekWeather() {
        Uri uri = Uri.parse(weekWeatherUrlView.getText().toString());
        Intent weekWeatherIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(weekWeatherIntent);
    }
}
