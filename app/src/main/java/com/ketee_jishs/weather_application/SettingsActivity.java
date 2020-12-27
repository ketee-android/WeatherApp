package com.ketee_jishs.weather_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button okButtonSettings = (Button)findViewById(R.id.okButtonSettings);
        okButtonSettings.setOnClickListener(v -> {
            onClickOkButtonSettings(okButtonSettings);
        });

        Button aboutButton = (Button)findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(v -> {
            onClickAboutButton(aboutButton);
        });
    }

    public void onClickOkButtonSettings(View view) {
        startActivity(new Intent(SettingsActivity.this, MainActivity.class));
    }

    public void onClickAboutButton(View view) {
        startActivity(new Intent(SettingsActivity.this, AboutActivity.class));
    }
}