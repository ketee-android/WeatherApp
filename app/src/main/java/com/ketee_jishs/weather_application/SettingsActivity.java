package com.ketee_jishs.weather_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private Button okButtonSettings;
    private Button aboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        findViews();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toast.makeText(this, "onCreateSettings", Toast.LENGTH_SHORT).show();
        Log.d("onCreate", "onCreateSettings");

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

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStartSettings", Toast.LENGTH_SHORT).show();
        Log.d("onStart", "onStartSettings");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResumeSettings", Toast.LENGTH_SHORT).show();
        Log.d("onResume", "onResumeSettings");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPauseSettings", Toast.LENGTH_SHORT).show();
        Log.d("onPause", "onPauseSettings");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStopSettings", Toast.LENGTH_SHORT).show();
        Log.d("onStop", "onStopSettings");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestartSettings", Toast.LENGTH_SHORT).show();
        Log.d("onRestart", "onRestartSettings");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroySettings", Toast.LENGTH_SHORT).show();
        Log.d("onDestroy", "onDestroySettings");
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