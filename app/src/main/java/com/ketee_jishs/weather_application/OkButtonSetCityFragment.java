package com.ketee_jishs.weather_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

public class OkButtonSetCityFragment extends Fragment {

    static MaterialButton okButtonSetCity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ok_button_set_city, container, false);
        okButtonSetCity = rootView.findViewById(R.id.okButtonSetCity);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Animation animAlpha = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
        okButtonSetCity.setOnClickListener(v -> {
            okButtonSetCity.startAnimation(animAlpha);
            onClickOkButtonChoseCity();
        });
    }

    public void onClickOkButtonChoseCity() {
        if (!ChoseCityFragment.isCityExist()) {
            Snackbar snackbar = Snackbar.make(ChoseCityActivity.coordLayoutChoseCity, R.string.city_is_not_exist, Snackbar.LENGTH_LONG);
            snackbar.show();
        } else if (ChoseCityFragment.isCityExist()) {
            ChoseAdditionalPapamsFragment.onClickAtmospherePressureCheckBox();
            ChoseAdditionalPapamsFragment.onClickWindSpeedCheckBox();
            ChoseAdditionalPapamsFragment.onClickAirHumidityCheckBox();
            ChoseAdditionalPapamsFragment.viewsSettingsForGone();
            String city = ChoseCityFragment.choseCityAutoCompleteTextView.getText().toString();
            ChoseCityActivity.citiesList.add(city);
            if (ChoseCityActivity.citiesList.size() > 7) {
                ChoseCityActivity.citiesList.remove(0);
            }
            Intent chosenCity = new Intent();
            chosenCity.putExtra(CityDataInterface.chosenCityDataKey(), city);
            getActivity().setResult(getActivity().RESULT_OK, chosenCity);
            getActivity().finish();
        }
    }
}
