package com.ketee_jishs.weather_application;

public class ItemWeather {
    private String nameOfDay;
    private String dayWeath;
    private String nightWeath;


    public ItemWeather(String nameOfDay, String dayWeath, String nightWeath) {
        this.nameOfDay = nameOfDay;
        this.dayWeath = dayWeath;
        this.nightWeath = nightWeath;
    }

    public String getNameOfDay() {
        return nameOfDay;
    }

    public String getDayWeath() {
        return dayWeath;
    }

    public String getNightWeath() {
        return nightWeath;
    }
}
