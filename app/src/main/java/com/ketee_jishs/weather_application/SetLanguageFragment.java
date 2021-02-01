package com.ketee_jishs.weather_application;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;

public class SetLanguageFragment extends Fragment {
    public static int flag = 0;

    private Configuration config;
    static Locale lang = Locale.forLanguageTag("ru");

    static RadioGroup radioGroupLanguage;
    static RadioButton radioButtonRussianLang;
    static RadioButton radioButtonEnglishLang;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_set_language, container, false);
        radioGroupLanguage = rootView.findViewById(R.id.radioGroupLanguage);
        radioButtonRussianLang = rootView.findViewById(R.id.radioButtonRussianLang);
        radioButtonEnglishLang = rootView.findViewById(R.id.radioButtonEnglishLang);
        config = new Configuration();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (flag == 1) {
            radioButtonRussianLang.setChecked(true);
        } else if (flag == 2) {
            radioButtonEnglishLang.setChecked(true);
        } else {
            radioButtonRussianLang.setChecked(true);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        initLanguageListener();
    }

    private void initLanguageListener() {
        radioGroupLanguage.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.radioButtonRussianLang:
                    flag = 1;
                    lang = new Locale("ru");
                    break;
                case R.id.radioButtonEnglishLang:
                    flag = 2;
                    lang = new Locale("en");
                    break;
            }
            Locale.setDefault(lang);
            config.locale = lang;
            getActivity().getResources().updateConfiguration(config, getActivity().getResources().getDisplayMetrics());
        });
    }
}
