package com.ketee_jishs.weather_application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;

import java.util.Arrays;
import java.util.List;

public class ChoseCityFragment extends Fragment {

    static MaterialAutoCompleteTextView choseCityAutoCompleteTextView;

    static String[] citiesArray;
    private String[] weekWeatherArray;

    static String cityName;
    static String[] arrayForOpenweathermap;

    static int pos;

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
        weekWeatherArray = getResources().getStringArray(R.array.urls_array);
        arrayForOpenweathermap = getResources().getStringArray(R.array.cities_array_for_openweathermap);
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
                    TemperatureFragment.weekWeatherUrlView.setText(weekWeatherArray[pos]);
                    cityName = arrayForOpenweathermap[pos];
                    break;
                }
            }
        });
    }

    static boolean isCityExist() {
        String chosenCity = choseCityAutoCompleteTextView.getText().toString();
        List<String> citiesList = Arrays.asList(citiesArray);
        return citiesList.contains(chosenCity);
    }

}

