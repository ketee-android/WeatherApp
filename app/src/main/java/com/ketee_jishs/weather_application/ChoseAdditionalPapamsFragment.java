package com.ketee_jishs.weather_application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ChoseAdditionalPapamsFragment extends Fragment {
    private static int flagOne = 0;
    private static int flagTwo = 0;
    private static int flagThree = 0;

    static CheckBox checkBoxPressure;
    static CheckBox checkBoxWindSpeed;
    static CheckBox checkBoxAirHumidity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chose_add_params, container, false);
        checkBoxPressure = rootView.findViewById(R.id.checkBoxPressure);
        checkBoxWindSpeed = rootView.findViewById(R.id.checkBoxWindSpeed);
        checkBoxAirHumidity = rootView.findViewById(R.id.checkBoxAirHumidity);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (flagOne == 1) {
            checkBoxPressure.setChecked(true);
        }
        if (flagTwo == 1) {
            checkBoxWindSpeed.setChecked(true);
        }
        if (flagThree == 1) {
            checkBoxAirHumidity.setChecked(true);
        }

        onClickAtmospherePressureCheckBox();
        onClickWindSpeedCheckBox();
        onClickAirHumidityCheckBox();
        viewsSettingsForGone();
    }

    static void onClickAtmospherePressureCheckBox() {
        if (checkBoxPressure.isChecked()) {
            flagOne = 1;
            MainActivity.addParamsLayout.setVisibility(View.VISIBLE);
            AdditionalParametersFragment.atmPressureImageView.setVisibility(View.VISIBLE);
            AdditionalParametersFragment.atmospherePressureInfoView.setVisibility(View.VISIBLE);
            AdditionalParametersFragment.atmospherePressureMainView.setVisibility(View.VISIBLE);
            AdditionalParametersFragment.atmospherePressureIndicatorView.setVisibility(View.VISIBLE);
        } else {
            flagOne = 0;
            AdditionalParametersFragment.atmPressureImageView.setVisibility(View.GONE);
            AdditionalParametersFragment.atmospherePressureInfoView.setVisibility(View.GONE);
            AdditionalParametersFragment.atmospherePressureMainView.setVisibility(View.GONE);
            AdditionalParametersFragment.atmospherePressureIndicatorView.setVisibility(View.GONE);
        }
    }

    static void onClickWindSpeedCheckBox() {
        if (checkBoxWindSpeed.isChecked()) {
            flagTwo = 1;
            MainActivity.addParamsLayout.setVisibility(View.VISIBLE);
            AdditionalParametersFragment.lineTwo.setVisibility(View.VISIBLE);
            AdditionalParametersFragment.windSpeedImageView.setVisibility(View.VISIBLE);
            AdditionalParametersFragment.windSpeedInfoView.setVisibility(View.VISIBLE);
            AdditionalParametersFragment.windSpeedMainView.setVisibility(View.VISIBLE);
            AdditionalParametersFragment.windSpeedIndicatorView.setVisibility(View.VISIBLE);
        } else {
            flagTwo = 0;
            AdditionalParametersFragment.lineTwo.setVisibility(View.GONE);
            AdditionalParametersFragment.windSpeedImageView.setVisibility(View.GONE);
            AdditionalParametersFragment.windSpeedInfoView.setVisibility(View.GONE);
            AdditionalParametersFragment.windSpeedMainView.setVisibility(View.GONE);
            AdditionalParametersFragment.windSpeedIndicatorView.setVisibility(View.GONE);
        }
    }

    static void onClickAirHumidityCheckBox() {
        if (checkBoxAirHumidity.isChecked()) {
            flagThree = 1;
            MainActivity.addParamsLayout.setVisibility(View.VISIBLE);
            AdditionalParametersFragment.lineThree.setVisibility(View.VISIBLE);
            AdditionalParametersFragment.humidityImageView.setVisibility(View.VISIBLE);
            AdditionalParametersFragment.humidityInfoView.setVisibility(View.VISIBLE);
            AdditionalParametersFragment.humidityMainView.setVisibility(View.VISIBLE);
            AdditionalParametersFragment.humidityIndicatorView.setVisibility(View.VISIBLE);
        } else {
            flagThree = 0;
            AdditionalParametersFragment.lineThree.setVisibility(View.GONE);
            AdditionalParametersFragment.humidityImageView.setVisibility(View.GONE);
            AdditionalParametersFragment.humidityInfoView.setVisibility(View.GONE);
            AdditionalParametersFragment.humidityMainView.setVisibility(View.GONE);
            AdditionalParametersFragment.humidityIndicatorView.setVisibility(View.GONE);
        }
    }

    static void viewsSettingsForGone() {
        if (checkBoxPressure.isChecked() == false && checkBoxWindSpeed.isChecked() == false && checkBoxAirHumidity.isChecked() == false) {
            MainActivity.addParamsLayout.setVisibility(View.GONE);
            AdditionalParametersFragment.lineTwo.setVisibility(View.GONE);
            AdditionalParametersFragment.lineThree.setVisibility(View.GONE);
        }
    }

}
