package com.ketee_jishs.weather_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

import static android.app.Activity.RESULT_OK;

public class ForecastForCityFragment extends Fragment {
    static final String chosenCityViewDataKey = "chosenCityViewDataKey";

    static TextView chosenCityView;
    static MaterialButton cityButton;

    private final int choseCityActivityRequestCode = 15;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_forecast_for_city, container, false);

        chosenCityView = rootView.findViewById(R.id.chosenCityView);

//        final Animation animAlpha = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
//        cityButton.setOnClickListener(v -> {
//            cityButton.startAnimation(animAlpha);
//            onClickSetCity();
//        });
        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        String city = chosenCityView.getText().toString();
        outState.putString(chosenCityViewDataKey, city);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cityButton = view.findViewById(R.id.cityButton);
        if (savedInstanceState != null) {
            String city = savedInstanceState.getString(chosenCityViewDataKey);
            chosenCityView.setText(city);
        }
    }

//    public void onClickSetCity() {
//        Intent chosenCity = new Intent(getActivity(), ChoseCityActivity.class);
//        startActivityForResult(chosenCity, choseCityActivityRequestCode);
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == choseCityActivityRequestCode && resultCode == RESULT_OK) {
            chosenCityView.setText(data.getStringExtra(CityDataInterface.chosenCityDataKey()));
        }
    }
}