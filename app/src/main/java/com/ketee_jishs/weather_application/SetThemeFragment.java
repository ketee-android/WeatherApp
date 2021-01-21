package com.ketee_jishs.weather_application;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

public class SetThemeFragment extends Fragment {

    static RadioGroup radioGroupThemes;
    static RadioButton radioButtonDarkTheme;
    static RadioButton radioButtonLightTheme;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_set_theme, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        radioGroupThemes = view.findViewById(R.id.radioGroupThemes);
        radioButtonDarkTheme = view.findViewById(R.id.radioButtonDarkTheme);
        radioButtonLightTheme = view.findViewById(R.id.radioButtonLightTheme);

        initThemeListener();
    }

    // Работает плохо. Для перезапуска темы надо перезапускать приложение //
    private void initThemeListener() {
        radioGroupThemes.setOnCheckedChangeListener((group, checkedId) -> {
            getActivity().setTheme(checkedId);
            if (radioButtonLightTheme.isChecked()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else if (radioButtonDarkTheme.isChecked()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        });
    }
}