package com.ketee_jishs.weather_application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.app.Activity.RESULT_OK;

public class TemperatureFragment extends Fragment {
    private final String dayTempDataKey = "dayTempDataKey";
    private final String nightTempDataKey = "nightTempDataKey";
    private final String weekWeatherDataKey = "weekWeatherDataKey";

    static TextView dayDegreesView;
    static TextView nightDegreesView;
    static TextView weekWeatherUrlView;
    static Button weekWeatherButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_temperature, container, false);

        dayDegreesView = rootView.findViewById(R.id.dayDegreesView);
        nightDegreesView = rootView.findViewById(R.id.nightDegreesView);
        weekWeatherButton = rootView.findViewById(R.id.weekWeatherButton);
        weekWeatherUrlView = rootView.findViewById(R.id.weekWeatherUrlView);

        final Animation animAlpha = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
        weekWeatherButton.setOnClickListener(v -> {
            weekWeatherButton.startAnimation(animAlpha);
            onClickWeekWeather();
        });

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
        }

    }

    public void onClickWeekWeather() {
        Uri uri = Uri.parse(weekWeatherUrlView.getText().toString());
        Intent weekWeatherIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(weekWeatherIntent);
    }
}
