package com.ketee_jishs.weather_application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WeatherFiveDaysFragment extends Fragment {

    static TextView dayOneView;
    static TextView dayTwoView;
    static TextView dayThreeView;
    static TextView dayFourView;
    static TextView dayFiveView;

    static TextView degrDayOneView;
    static TextView degrDayTwoView;
    static TextView degrDayThreeView;
    static TextView degrDayFourView;
    static TextView degrDayFiveView;

    static TextView descriptionOne;
    static TextView descriptionTwo;
    static TextView descriptionThree;
    static TextView descriptionFour;
    static TextView descriptionFive;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weather_five_days, container, false);
        dayOneView = rootView.findViewById(R.id.dayOneView);
        dayTwoView = rootView.findViewById(R.id.dayTwoView);
        dayThreeView = rootView.findViewById(R.id.dayThreeView);
        dayFourView = rootView.findViewById(R.id.dayFourView);
        dayFiveView = rootView.findViewById(R.id.dayFiveView);

        degrDayOneView = rootView.findViewById(R.id.degrDayOneView);
        degrDayTwoView = rootView.findViewById(R.id.degrDayTwoView);
        degrDayThreeView = rootView.findViewById(R.id.degrDayThreeView);
        degrDayFourView = rootView.findViewById(R.id.degrDayFourView);
        degrDayFiveView = rootView.findViewById(R.id.degrDayFiveView);

        descriptionOne = rootView.findViewById(R.id.descriptionOne);
        descriptionTwo = rootView.findViewById(R.id.descriptionTwo);
        descriptionThree = rootView.findViewById(R.id.descriptionThree);
        descriptionFour = rootView.findViewById(R.id.descriptionFour);
        descriptionFive = rootView.findViewById(R.id.descriptionFive);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}