package com.ketee_jishs.weather_application.model;

public class Main{
    private float temp;
    private float feels_like;
    private float temp_min;
    private float temp_max;
    private int pressure;
    private int humidity;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getFeelsLike() {
        return feels_like;
    }

    public void setFeelsLike(float feels_like) {
        this.feels_like = feels_like;
    }

    public float getTempMin() {
        return temp_min;
    }

    public void setTempMin(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTempMax() {
        return temp_max;
    }

    public void setTempMax(float temp_max) {
        this.temp_max = temp_max;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
