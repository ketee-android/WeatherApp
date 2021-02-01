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

public class AboutButtonFragment extends Fragment {

    static MaterialButton aboutButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about_button, container, false);
        aboutButton = rootView.findViewById(R.id.aboutButton);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Animation animAlpha = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
        aboutButton.setOnClickListener(v -> {
            aboutButton.startAnimation(animAlpha);
            onClickAboutButton();
        });
    }

    public void onClickAboutButton() {
        startActivity(new Intent(getContext(), AboutActivity.class));
    }
}
