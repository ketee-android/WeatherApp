package com.ketee_jishs.weather_application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ChoseCityFragment extends Fragment {

    static AutoCompleteTextView choseCityAutoCompleteTextView;

    static String[] citiesArray;
    private String[] dayDegreesArray;
    private String[] nightDegreesArray;
    private String[] weekWeatherArray;
    private String[] atmPressureArray;
    private String[] windSpeedArray;
    private String[] humidityArray;

    static int pos;

    private TextView setChosenCityTitleTextView;
    static final String setChosenCityTitleDataKey = "setChosenCityTitleDataKey";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chose_city, container, false);
        choseCityAutoCompleteTextView = rootView.findViewById(R.id.choseCityAutoCompleteTextView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findResources();
        setAdapterChooseCity();
        onCityClickListener();
    }

    @Override
    public void onStart() {
        super.onStart();
        choseCityAutoCompleteTextView.setText(ForecastForCityFragment.chosenCityView.getText().toString());
    }

    private void findResources() {
        citiesArray = getResources().getStringArray(R.array.cities_array);
        dayDegreesArray = getResources().getStringArray(R.array.day_degrees_array);
        nightDegreesArray = getResources().getStringArray(R.array.night_degrees_array);
        weekWeatherArray = getResources().getStringArray(R.array.urls_array);
        atmPressureArray = getResources().getStringArray(R.array.atmosphere_pressure_array);
        windSpeedArray = getResources().getStringArray(R.array.wind_speed_array);
        humidityArray = getResources().getStringArray(R.array.humidity_array);
    }

    public void setAdapterChooseCity() {
        ArrayAdapter<?> citiesAdapter = ArrayAdapter.createFromResource(getContext(), R.array.cities_array, R.layout.drop_down_auto_complete);
        choseCityAutoCompleteTextView.setAdapter(citiesAdapter);
    }

    private void onCityClickListener() {
        choseCityAutoCompleteTextView.setOnItemClickListener((parent, view, position, rowId) -> {
            String selection = (String) parent.getItemAtPosition(position);

            for (int i = 0; i < citiesArray.length; i++) {
                if (citiesArray[i].equals(selection)) {
                    pos = i;
                    TemperatureFragment.dayDegreesView.setText(dayDegreesArray[pos]);
                    TemperatureFragment.nightDegreesView.setText(nightDegreesArray[pos]);
                    TemperatureFragment.weekWeatherUrlView.setText(weekWeatherArray[pos]);
                    AdditionalParametersFragment.atmospherePressureInfoView.setText(atmPressureArray[pos]);
                    AdditionalParametersFragment.windSpeedInfoView.setText(windSpeedArray[pos]);
                    AdditionalParametersFragment.humidityInfoView.setText(humidityArray[pos]);
                    break;
                }
            }
        });
    }
}
