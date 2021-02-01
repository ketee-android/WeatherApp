package com.ketee_jishs.weather_application;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class ChoseCityActivity extends AppCompatActivity implements OnItemCityClickInterface {
    private RecyclerView recViewCity;
    static RecViewCitiesDataAdapter adapterCity;
    static CoordinatorLayout coordLayoutChoseCity;

    static ArrayList<String> citiesList = new ArrayList<>(Arrays.asList("Москва"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_city);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Drawable drawable = getResources().getDrawable(R.drawable.action_bar);
        actionBar.setBackgroundDrawable(drawable);
    }

    @Override
    protected void onStart() {
        super.onStart();
        findViews();
        setupRecycledView();
    }

    private void findViews() {
        recViewCity = findViewById(R.id.recViewCity);
        coordLayoutChoseCity = findViewById(R.id.coordLayoutChoseCity);
    }

    private void setupRecycledView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, true);
        recViewCity.setLayoutManager(layoutManager);
        adapterCity = new RecViewCitiesDataAdapter(citiesList, this);
        recViewCity.setAdapter(adapterCity);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(intent, 0);
        return true;
    }

    @Override
    public void onItemCityClick(String itemText) {
        ChoseAdditionalPapamsFragment.onClickAtmospherePressureCheckBox();
        ChoseAdditionalPapamsFragment.onClickWindSpeedCheckBox();
        ChoseAdditionalPapamsFragment.onClickAirHumidityCheckBox();
        ChoseAdditionalPapamsFragment.viewsSettingsForGone();
        Intent recyclerCity = new Intent();
        recyclerCity.putExtra(CityDataInterface.chosenCityDataKey(), itemText);
        setResult(RESULT_OK, recyclerCity);
        finish();
    }
}