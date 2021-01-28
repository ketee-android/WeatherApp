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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

public class ChoseCityActivity extends AppCompatActivity implements OnItemCityClickInterface, View.OnClickListener {
    private RecyclerView recViewCity;
    static RecViewCitiesDataAdapter adapterCity;

    static ArrayList<String> citiesList = new ArrayList<>(Arrays.asList("Москва"));

    private CoordinatorLayout coordLayoutChoseCity;
    private FloatingActionButton floatingButtonChoseCity;

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
        floatingButtonChoseCity.setOnClickListener(this);
        OkButtonSetCityFragment.okButtonSetCity.setOnClickListener(this);
    }

    private void findViews() {
        recViewCity = findViewById(R.id.recViewCity);
        coordLayoutChoseCity = findViewById(R.id.coordLayoutChoseCity);
        floatingButtonChoseCity = findViewById(R.id.floatingButtonChoseCity);
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

    @Override
    public void onClick(View view) {
        final Animation animAlpha = AnimationUtils.loadAnimation(getBaseContext(), R.anim.alpha);
        int id = view.getId();
        switch (id) {
            case R.id.okButtonSetCity: {
                Snackbar snackbar = Snackbar
                        .make(coordLayoutChoseCity, R.string.set_settings, Snackbar.LENGTH_LONG)
                        .setAction(R.string.yes, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                OkButtonSetCityFragment.okButtonSetCity.startAnimation(animAlpha);
                                ChoseAdditionalPapamsFragment.onClickAtmospherePressureCheckBox();
                                ChoseAdditionalPapamsFragment.onClickWindSpeedCheckBox();
                                ChoseAdditionalPapamsFragment.onClickAirHumidityCheckBox();
                                ChoseAdditionalPapamsFragment.viewsSettingsForGone();
                                String city = ChoseCityFragment.choseCityAutoCompleteTextView.getText().toString();
                                ForecastForCityFragment.chosenCityView.setText(ChoseCityFragment.choseCityAutoCompleteTextView.getText().toString());
                                citiesList.add(city);
                                if (citiesList.size() > 7) {
                                    citiesList.remove(0);
                                }
                                Intent chosenCity = new Intent();
                                chosenCity.putExtra(CityDataInterface.chosenCityDataKey(), city);
                                setResult(RESULT_OK, chosenCity);
                                finish();
                            }
                        });
                snackbar.show();
                break;
            }
            case R.id.floatingButtonChoseCity: {
                Snackbar snackbar = Snackbar
                        .make(coordLayoutChoseCity, R.string.you_are_in_chose_city, Snackbar.LENGTH_SHORT);
                snackbar.show();
                break;
            }
        }
    }
}