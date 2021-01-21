package com.ketee_jishs.weather_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OkButtonSetCityFragment extends Fragment {

    private Button okButtonSetCity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ok_button_set_city, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        okButtonSetCity = view.findViewById(R.id.okButtonSetCity);

        final Animation animAlpha = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
        okButtonSetCity.setOnClickListener(v -> {
            okButtonSetCity.startAnimation(animAlpha);
            onClickOkButtonChoseCity();
        });
    }

    public void onClickOkButtonChoseCity() {
        ChoseAdditionalPapamsFragment.onClickAtmospherePressureCheckBox();
        ChoseAdditionalPapamsFragment.onClickWindSpeedCheckBox();
        ChoseAdditionalPapamsFragment.onClickAirHumidityCheckBox();
        String city = ChoseCityFragment.choseCityAutoCompleteTextView.getText().toString();
        Intent chosenCity = new Intent();
        chosenCity.putExtra(CityDataInterface.chosenCityDataKey(), city);
        getActivity().setResult(getActivity().RESULT_OK, chosenCity);
        getActivity().finish();
    }
}
