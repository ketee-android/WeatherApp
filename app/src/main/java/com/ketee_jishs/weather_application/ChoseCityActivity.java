package com.ketee_jishs.weather_application;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ChoseCityActivity extends AppCompatActivity {

    private Button okButtonChoseCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_city);
        findViews();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toast.makeText(this, "onCreateChoseCity", Toast.LENGTH_SHORT).show();
        Log.d("onCreate", "onCreateChoseCity");

        okButtonChoseCity.setOnClickListener(v -> {
            onClickOkButtonChoseCity(okButtonChoseCity);
        });
    }

    private void findViews() {
        okButtonChoseCity = (Button)findViewById(R.id.okButtonSetCity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStartChoseCity", Toast.LENGTH_SHORT).show();
        Log.d("onStart", "onStartChoseCity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResumeChoseCity", Toast.LENGTH_SHORT).show();
        Log.d("onResume", "onResumeChoseCity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPauseChoseCity", Toast.LENGTH_SHORT).show();
        Log.d("onPause", "onPauseChoseCity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStopChoseCity", Toast.LENGTH_SHORT).show();
        Log.d("onStop", "onStopChoseCity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestartChoseCity", Toast.LENGTH_SHORT).show();
        Log.d("onRestart", "onRestartChoseCity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroyChoseCity", Toast.LENGTH_SHORT).show();
        Log.d("onDestroy", "onDestroyChoseCity");
    }

    public void onClickOkButtonChoseCity(View view) {
        startActivity(new Intent(ChoseCityActivity.this, MainActivity.class));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(intent, 0);
        return true;
    }
}