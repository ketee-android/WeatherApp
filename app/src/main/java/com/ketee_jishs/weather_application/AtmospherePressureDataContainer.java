package com.ketee_jishs.weather_application;

public class AtmospherePressureDataContainer {

    private static AtmospherePressureDataContainer instance;

    private AtmospherePressureDataContainer() {}

    static AtmospherePressureDataContainer getInstance() {
        if (instance == null) {
            instance = new AtmospherePressureDataContainer();
        }
        return instance;
    }
}
