package com.ketee_jishs.weather_application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

public class SetThemeFragment extends Fragment {
    public static int flag = 0;

    static RadioGroup radioGroupThemes;
    static RadioButton radioButtonDarkTheme;
    static RadioButton radioButtonLightTheme;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_set_theme, container, false);
        radioGroupThemes = rootView.findViewById(R.id.radioGroupThemes);
        radioButtonDarkTheme = rootView.findViewById(R.id.radioButtonDarkTheme);
        radioButtonLightTheme = rootView.findViewById(R.id.radioButtonLightTheme);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (flag == 1) {
            radioButtonDarkTheme.setChecked(true);
        } else if (flag == 2) {
            radioButtonLightTheme.setChecked(true);
        } else {
            radioButtonLightTheme.setChecked(true);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        initThemeListener();
    }

    void initThemeListener() {
        radioGroupThemes.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.radioButtonDarkTheme:
                    flag = 1;
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    break;
                case R.id.radioButtonLightTheme:
                    flag = 2;
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    break;
            }
        });
    }
}