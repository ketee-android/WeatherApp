package com.ketee_jishs.weather_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetCityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_city);

        Button okButtonSetCity = (Button)findViewById(R.id.okButtonSetCity);
        okButtonSetCity.setOnClickListener(v -> {
            onClickOkButtonSetCity(okButtonSetCity);
        });
    }

    public void onClickOkButtonSetCity(View view) {
        startActivity(new Intent(SetCityActivity.this, MainActivity.class));
    }
}