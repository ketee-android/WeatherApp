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
    private Configuration config = new Configuration();
    private Locale locale;

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
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        initLanguageListener();
    }

//    private void initLanguageListener() {
//        radioGroupLanguage.setOnCheckedChangeListener((group, checkedId) -> {
//            if (radioButtonRussianLang.isChecked()) {
//                locale = new Locale("ru");
//            }
//            if (radioButtonEnglishLang.isChecked()) {
//                locale = new Locale("en");
//            }
//            Locale.setDefault(locale);
//            config.locale = locale;
//            getActivity().getResources().updateConfiguration(config, getActivity().getResources().getDisplayMetrics());
//        });
//    }
}
