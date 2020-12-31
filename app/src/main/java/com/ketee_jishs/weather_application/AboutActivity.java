package com.ketee_jishs.weather_application;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    private Button okButtonAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toast.makeText(this, "onCreateAbout", Toast.LENGTH_SHORT).show();
        Log.d("onCreate", "onCreateAbout");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStartAbout", Toast.LENGTH_SHORT).show();
        Log.d("onStart", "onStartAbout");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResumeAbout", Toast.LENGTH_SHORT).show();
        Log.d("onResume", "onResumeAbout");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPauseAbout", Toast.LENGTH_SHORT).show();
        Log.d("onPause", "onPauseAbout");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStopAbout", Toast.LENGTH_SHORT).show();
        Log.d("onStop", "onStopAbout");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestartAbout", Toast.LENGTH_SHORT).show();
        Log.d("onRestart", "onRestartAbout");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroyAbout", Toast.LENGTH_SHORT).show();
        Log.d("onDestroy", "onDestroyAbout");
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivityForResult(intent, 0);
        return true;
    }
}