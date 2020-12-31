package com.ketee_jishs.weather_application;

public class WindSpeedDataContainer {

    private static WindSpeedDataContainer instance;

    private WindSpeedDataContainer() {}

    static WindSpeedDataContainer getInstance() {
        if (instance == null) {
            instance = new WindSpeedDataContainer();
        }
        return instance;
    }
}
