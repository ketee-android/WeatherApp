package com.ketee_jishs.weather_application;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

    private CoordinatorLayout coordLayoutSettings;
    private FloatingActionButton floatingButtonSettings;
    private ImageButton aboutButtonSettings;
    private ImageButton homeButtonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Drawable drawable = getResources().getDrawable(R.drawable.action_bar);
        actionBar.setBackgroundDrawable(drawable);

        findViews();
        floatingButtonSettings.setOnClickListener(this);
        OkButtonSettingsFragment.okButtonSettings.setOnClickListener(this);
        AboutButtonFragment.aboutButton.setOnClickListener(this);
        aboutButtonSettings.setOnClickListener(this);
        homeButtonSettings.setOnClickListener(this);
    }

    public void findViews() {
        coordLayoutSettings = findViewById(R.id.coordLayoutSettings);
        floatingButtonSettings = findViewById(R.id.floatingButtonSettings);
        aboutButtonSettings = findViewById(R.id.aboutButtonSettings);
        homeButtonSettings = findViewById(R.id.homeButtonSettings);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(intent, 0);
        return true;
    }

    @Override
    public void onClick(View view) {
        final Animation animAlpha = AnimationUtils.loadAnimation(getBaseContext(), R.anim.alpha);
        int id = view.getId();
        switch (id) {
            case R.id.aboutButtonSettings: {
                Snackbar snackbar = Snackbar
                        .make(coordLayoutSettings, R.string.go_to_about_screen, Snackbar.LENGTH_LONG)
                        .setAction(R.string.yes, new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                homeButtonSettings.startAnimation(animAlpha);
                                startActivity(new Intent(SettingsActivity.this, AboutActivity.class));
                            }
                        });
                snackbar.show();
                break;
            }
            case R.id.homeButtonSettings: {
                Snackbar snackbar = Snackbar
                        .make(coordLayoutSettings, R.string.go_to_main_screen, Snackbar.LENGTH_LONG)
                        .setAction(R.string.yes, new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                homeButtonSettings.startAnimation(animAlpha);
                                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
                            }
                        });
                snackbar.show();
                break;
            }
            case R.id.okButtonSettings: {
                Snackbar snackbar = Snackbar
                        .make(coordLayoutSettings, R.string.set_settings, Snackbar.LENGTH_LONG)
                        .setAction(R.string.yes, new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                OkButtonSettingsFragment.okButtonSettings.startAnimation(animAlpha);
                                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
                            }
                        });
                snackbar.show();
                break;
            }
            case R.id.aboutButton: {
                Snackbar snackbar = Snackbar
                        .make(coordLayoutSettings, R.string.go_to_about_screen, Snackbar.LENGTH_LONG)
                        .setAction(R.string.yes, new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                AboutButtonFragment.aboutButton.startAnimation(animAlpha);
                                startActivity(new Intent(SettingsActivity.this, AboutActivity.class));
                            }
                        });
                snackbar.show();
                break;
            }
            case R.id.floatingButtonSettings: {
                Snackbar snackbar = Snackbar
                        .make(coordLayoutSettings, R.string.you_are_in_settings, Snackbar.LENGTH_SHORT);
                snackbar.show();
                break;
            }
        }
    }
}