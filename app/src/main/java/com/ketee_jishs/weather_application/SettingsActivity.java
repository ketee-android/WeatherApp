package com.ketee_jishs.weather_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity{

    private Button okButtonSettings;
    private Button aboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        findViews();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        okButtonSettings.setOnClickListener(v -> {
            onClickOkButtonSettings(okButtonSettings);
        });

        aboutButton.setOnClickListener(v -> {
            onClickAboutButton(aboutButton);
        });
    }

    private void findViews() {
        okButtonSettings = (Button)findViewById(R.id.okButtonSettings);
        aboutButton = (Button)findViewById(R.id.aboutButton);
    }

    public void onClickOkButtonSettings(View view) {
        startActivity(new Intent(SettingsActivity.this, MainActivity.class));
    }

    public void onClickAboutButton(View view) {
        startActivity(new Intent(SettingsActivity.this, AboutActivity.class));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(intent, 0);
        return true;
    }
}