package com.ketee_jishs.weather_application;

public class HumidityDataContainer {

    private static HumidityDataContainer instance;

    private HumidityDataContainer() {}

    static HumidityDataContainer getInstance() {
        if (instance == null) {
            instance = new HumidityDataContainer();
        }
        return instance;
    }
}
