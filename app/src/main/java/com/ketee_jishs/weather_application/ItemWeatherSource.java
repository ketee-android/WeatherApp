package com.ketee_jishs.weather_application;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class ItemWeatherSource {
    public List<ItemWeather> dataSource;
    public Resources resources;
    static String[] citiesArray;
    private String[] days;
    private String[] dayWeather;
    private String[] nightWeather;

    static String[] tomorrowDayWeather;
    static String[] tomorrowNightWeather;
    static String[] tuesdayDayWeather;
    static String[] tuesdayNightWeather;
    static String[] wednesdayDayWeather;
    static String[] wednesdayNightWeather;
    static String[] thursdayDayWeather;
    static String[] thursdayNightWeather;
    static String[] fridayDayWeather;
    static String[] fridayNightWeather;
    static String[] saturdayDayWeather;
    static String[] saturdayNightWeather;
    static String[] sundayDayWeather;
    static String[] sundayNightWeather;

    static String tomorrowDW;
    static String tuesdayDW;
    static String wednesdayDW;
    static String thursdayDW;
    static String fridayDW;
    static String saturdayDW;
    static String sundayDW;

    static String tomorrowNW;
    static String tuesdayNW;
    static String wednesdayNW;
    static String thursdayNW;
    static String fridayNW;
    static String saturdayNW;
    static String sundayNW;

    public ItemWeatherSource(Resources resources) {
        dataSource = new ArrayList<>(7);
        this.resources = resources;
    }

    public ItemWeatherSource build() {
        findArrays();
        days = resources.getStringArray(R.array.days_of_week);
        buildWeatherArrays();
        for (int i = 0; i < days.length; i++) {
            dataSource.add(new ItemWeather(days[i], dayWeather[i], nightWeather[i]));
        }
        return this;
    }

    private void findArrays() {
        citiesArray = resources.getStringArray(R.array.cities_array);
        tomorrowDayWeather = resources.getStringArray(R.array.tomorrow_day_weather);
        tomorrowNightWeather = resources.getStringArray(R.array.tomorrow_night_weather);
        tuesdayDayWeather = resources.getStringArray(R.array.tuesday_day_weather);
        tuesdayNightWeather = resources.getStringArray(R.array.tuesday_night_weather);
        wednesdayDayWeather = resources.getStringArray(R.array.wednesday_day_weather);
        wednesdayNightWeather = resources.getStringArray(R.array.wednesday_night_weather);
        thursdayDayWeather = resources.getStringArray(R.array.thursday_day_weather);
        thursdayNightWeather = resources.getStringArray(R.array.thursday_night_weather);
        fridayDayWeather = resources.getStringArray(R.array.friday_day_weather);
        fridayNightWeather = resources.getStringArray(R.array.friday_night_weather);
        saturdayDayWeather = resources.getStringArray(R.array.saturday_day_weather);
        saturdayNightWeather = resources.getStringArray(R.array.saturday_night_weather);
        sundayDayWeather = resources.getStringArray(R.array.sunday_day_weather);
        sundayNightWeather = resources.getStringArray(R.array.sunday_night_weather);
    }

    private void buildWeatherArrays() {
        for (int position = 0; position < citiesArray.length; position++) {
            if (citiesArray[position].equals(ForecastForCityFragment.chosenCityView.getText().toString())) {
                tomorrowDW = tomorrowDayWeather[position];
                tuesdayDW = tuesdayDayWeather[position];
                wednesdayDW = wednesdayDayWeather[position];
                thursdayDW = thursdayDayWeather[position];
                fridayDW = fridayDayWeather[position];
                saturdayDW = saturdayDayWeather[position];
                sundayDW = sundayDayWeather[position];

                tomorrowNW = tomorrowNightWeather[position];
                tuesdayNW = tuesdayNightWeather[position];
                wednesdayNW = wednesdayNightWeather[position];
                thursdayNW = thursdayNightWeather[position];
                fridayNW = fridayNightWeather[position];
                saturdayNW = saturdayNightWeather[position];
                sundayNW = sundayNightWeather[position];

                dayWeather = new String[]{tomorrowDW, tuesdayDW, wednesdayDW, thursdayDW, fridayDW, saturdayDW, sundayDW};
                nightWeather = new String[]{tomorrowNW, tuesdayNW, wednesdayNW, thursdayNW, fridayNW, saturdayNW, sundayNW};

                break;
            }
        }
    }

    public ItemWeather getItem(int position) {
        return dataSource.get(position);
    }

    public int size() {
        return dataSource.size();
    }
}
