package com.ketee_jishs.weather_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AppNameFragment extends Fragment {

    static ImageButton settingsButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_app_name, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Animation animAlpha = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
        settingsButton = view.findViewById(R.id.settingsButton);

        settingsButton.setOnClickListener(v -> {
            settingsButton.startAnimation(animAlpha);
            onClickSettings();
        });
    }

    public void onClickSettings() {
        startActivity(new Intent(getContext(), SettingsActivity.class));
    }
}
