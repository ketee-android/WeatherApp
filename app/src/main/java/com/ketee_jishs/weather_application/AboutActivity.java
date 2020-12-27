package com.ketee_jishs.weather_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button okButtonAbout = (Button)findViewById(R.id.okButtonAbout);
        okButtonAbout.setOnClickListener(v -> {
            onClickOkButtonAbout(okButtonAbout);
        });
    }

    public void onClickOkButtonAbout(View view) {
        startActivity(new Intent(AboutActivity.this, SettingsActivity.class));
    }
}