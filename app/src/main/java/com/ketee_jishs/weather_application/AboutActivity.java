package com.ketee_jishs.weather_application;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{
    private CoordinatorLayout coordLayoutAbout;
    private FloatingActionButton floatingButtonAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Drawable drawable = getResources().getDrawable(R.drawable.action_bar);
        actionBar.setBackgroundDrawable(drawable);

        findViews();
        floatingButtonAbout.setOnClickListener(this);
    }

    public void findViews() {
        coordLayoutAbout = findViewById(R.id.coordLayoutAbout);
        floatingButtonAbout = findViewById(R.id.floatingButtonAbout);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivityForResult(intent, 0);
        return true;
    }

    @Override
    public void onClick(View view) {
        final Animation animAlpha = AnimationUtils.loadAnimation(getBaseContext(), R.anim.alpha);
        int id = view.getId();
        switch (id) {
            case R.id.floatingButtonAbout: {
                Snackbar snackbar = Snackbar
                        .make(coordLayoutAbout, R.string.you_are_in_about, Snackbar.LENGTH_SHORT);
                snackbar.show();
                break;
            }
        }
    }
}