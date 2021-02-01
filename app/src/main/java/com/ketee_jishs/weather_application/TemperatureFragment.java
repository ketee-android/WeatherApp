package com.ketee_jishs.weather_application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class TemperatureFragment extends Fragment {
    private final String dayTempDataKey = "dayTempDataKey";
    private final String feelsLikeTempDataKey = "feelsLikeTempDataKey";
    private final String maxTempDataKey = "maxTempDataKey";
    private final String minTempDataKey = "minTempDataKey";
    private final String weekWeatherDataKey = "weekWeatherDataKey";

    static TextView dayTempView;
    static TextView feelsLikeTempView;
    static TextView maxTempView;
    static TextView minTempView;
    static TextView weekWeatherUrlView;
    static TextView dateTimeView;
    static TextView descriptionView;

    static MaterialButton weekWeatherButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_temperature, container, false);

        dayTempView = rootView.findViewById(R.id.dayTempView);
        feelsLikeTempView = rootView.findViewById(R.id.feelsLikeTempView);
        maxTempView = rootView.findViewById(R.id.maxTempView);
        minTempView = rootView.findViewById(R.id.minTempView);
        dateTimeView = rootView.findViewById(R.id.dateTimeView);
        descriptionView = rootView.findViewById(R.id.descriptionView);

        weekWeatherUrlView = rootView.findViewById(R.id.weekWeatherUrlView);
        weekWeatherButton = rootView.findViewById(R.id.weekWeatherButton);

        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        String dayTemp = dayTempView.getText().toString();
        outState.putString(dayTempDataKey, dayTemp);

        String feelsLike = feelsLikeTempView.getText().toString();
        outState.putString(feelsLikeTempDataKey, feelsLike);

        String maxTemp = maxTempView.getText().toString();
        outState.putString(maxTempDataKey, maxTemp);

        String minTemp = minTempView.getText().toString();
        outState.putString(minTempDataKey, minTemp);

        String weekWeatherUrl = weekWeatherUrlView.getText().toString();
        outState.putString(weekWeatherDataKey, weekWeatherUrl);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            String dayTemp = savedInstanceState.getString(dayTempDataKey);
            dayTempView.setText(dayTemp);

            String feelsLike = savedInstanceState.getString(feelsLikeTempDataKey);
            feelsLikeTempView.setText(feelsLike);

            String maxTemp = savedInstanceState.getString(maxTempDataKey);
            feelsLikeTempView.setText(maxTemp);

            String minTemp = savedInstanceState.getString(minTempDataKey);
            feelsLikeTempView.setText(minTemp);

            String weekWeatherUrl = savedInstanceState.getString(weekWeatherDataKey);
            weekWeatherUrlView.setText(weekWeatherUrl);
        }

        final Animation animAlpha = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
        weekWeatherButton.setOnClickListener(v -> {
            weekWeatherButton.startAnimation(animAlpha);
            onClickWeekWeather();
        });
    }

    public void onClickWeekWeather() {
        Uri uri = Uri.parse(weekWeatherUrlView.getText().toString());
        Intent weekWeatherIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(weekWeatherIntent);
    }
}
