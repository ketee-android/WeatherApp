package com.ketee_jishs.weather_application;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AdditionalParametersFragment extends Fragment {

    static final String atmospherePressureDataKey = "atmospherePressureDataKey";
    static final String atmPressureVisibilityDataKey = "atmPressureVisibilityDataKey";

    static final String windSpeedDataKey = "windSpeedDataKey";
    static final String windSpeedVisibilityDataKey = "windSpeedVisibilityDataKey";

    static final String humidityDataKey = "humidityDataKey";
    static final String humidityVisibilityDataKey = "humidityVisibilityDataKey";

    static TextView atmospherePressureMainView;
    static TextView atmospherePressureInfoView;
    static TextView atmospherePressureIndicatorView;

    static TextView windSpeedMainView;
    static TextView windSpeedInfoView;
    static TextView windSpeedIndicatorView;

    static TextView humidityMainView;
    static TextView humidityInfoView;
    static TextView humidityIndicatorView;

    static View lineTwo;
    static View lineThree;

    static ImageView atmPressureImageView;
    static ImageView windSpeedImageView;
    static ImageView humidityImageView;

    static Button changeParamsButton;

    private final int choseCityActivityRequestCode = 15;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_additional_parameters, container, false);

        atmospherePressureMainView = rootView.findViewById(R.id.atmospherePressureMainView);
        atmospherePressureInfoView = rootView.findViewById(R.id.atmospherePressureInfoView);
        atmospherePressureIndicatorView = rootView.findViewById(R.id.atmospherePressureIndicatorView);

        windSpeedMainView = rootView.findViewById(R.id.windSpeedMainView);
        windSpeedInfoView = rootView.findViewById(R.id.windSpeedInfoView);
        windSpeedIndicatorView = rootView.findViewById(R.id.windSpeedIndicatorView);

        humidityMainView = rootView.findViewById(R.id.humidityMainView);
        humidityInfoView = rootView.findViewById(R.id.humidityInfoView);
        humidityIndicatorView = rootView.findViewById(R.id.humidityIndicatorView);

        lineTwo = rootView.findViewById(R.id.lineTwo);
        lineThree = rootView.findViewById(R.id.lineThree);

        atmPressureImageView = rootView.findViewById(R.id.atmPressureImageView);
        windSpeedImageView = rootView.findViewById(R.id.windSpeedImageView);
        humidityImageView = rootView.findViewById(R.id.humidityImageView);

        changeParamsButton = rootView.findViewById(R.id.changeParamsButton);
        final Animation animAlpha = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
        changeParamsButton.setOnClickListener(v -> {
            changeParamsButton.startAnimation(animAlpha);
            onClickChangeParams();
        });

        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        String atmospherePressure = atmospherePressureInfoView.getText().toString();
        String atmPressureVisibility = String.valueOf(atmospherePressureInfoView.getVisibility());
        outState.putString(atmospherePressureDataKey, atmospherePressure);
        outState.putString(atmPressureVisibilityDataKey, atmPressureVisibility);

        String windSpeed = windSpeedInfoView.getText().toString();
        String windSpeedVisibility = String.valueOf(windSpeedInfoView.getVisibility());
        outState.putString(windSpeedDataKey, windSpeed);
        outState.putString(windSpeedVisibilityDataKey, windSpeedVisibility);

        String humidity = humidityInfoView.getText().toString();
        String humidityVisibility = String.valueOf(humidityInfoView.getVisibility());
        outState.putString(humidityDataKey, humidity);
        outState.putString(humidityVisibilityDataKey, humidityVisibility);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {

            String atmospherePressure = savedInstanceState.getString(atmospherePressureDataKey);
            String atmPressureVisibility = savedInstanceState.getString(atmPressureVisibilityDataKey);
            atmospherePressureInfoView.setText(atmospherePressure);
            atmospherePressureInfoView.setVisibility(Integer.parseInt(atmPressureVisibility));
            atmospherePressureMainView.setVisibility(Integer.parseInt(atmPressureVisibility));
            atmospherePressureIndicatorView.setVisibility(Integer.parseInt(atmPressureVisibility));
            atmPressureImageView.setVisibility(Integer.parseInt(atmPressureVisibility));
            lineTwo.setVisibility(Integer.parseInt(atmPressureVisibility));

            String windSpeed = savedInstanceState.getString(windSpeedDataKey);
            String windSpeedVisibility = savedInstanceState.getString(windSpeedVisibilityDataKey);
            windSpeedInfoView.setText(windSpeed);
            windSpeedInfoView.setVisibility(Integer.parseInt(windSpeedVisibility));
            windSpeedMainView.setVisibility(Integer.parseInt(windSpeedVisibility));
            windSpeedIndicatorView.setVisibility(Integer.parseInt(windSpeedVisibility));
            windSpeedImageView.setVisibility(Integer.parseInt(windSpeedVisibility));
            lineThree.setVisibility(Integer.parseInt(windSpeedVisibility));

            String humidity = savedInstanceState.getString(humidityDataKey);
            String humidityVisibility = savedInstanceState.getString(humidityVisibilityDataKey);
            humidityInfoView.setText(humidity);
            humidityInfoView.setVisibility(Integer.parseInt(humidityVisibility));
            humidityMainView.setVisibility(Integer.parseInt(humidityVisibility));
            humidityIndicatorView.setVisibility(Integer.parseInt(humidityVisibility));
            humidityImageView.setVisibility(Integer.parseInt(humidityVisibility));
        }
    }

    public void onClickChangeParams() {
        Intent chosenCity = new Intent(getActivity(), ChoseCityActivity.class);
        startActivityForResult(chosenCity, choseCityActivityRequestCode);
    }


}
