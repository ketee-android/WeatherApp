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

public class OkButtonSettingsFragment extends Fragment {

    static Button okButtonSettings;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ok_button_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        okButtonSettings = view.findViewById(R.id.okButtonSettings);

        final Animation animAlpha = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);

        okButtonSettings.setOnClickListener(v -> {
            okButtonSettings.startAnimation(animAlpha);
            onClickOkButtonSettings(okButtonSettings);
        });
    }

    public void onClickOkButtonSettings(View view) {
        startActivity(new Intent(getContext(), MainActivity.class));
    }
}
