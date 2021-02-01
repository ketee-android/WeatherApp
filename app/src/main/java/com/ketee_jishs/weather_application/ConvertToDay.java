package com.ketee_jishs.weather_application;

import android.icu.text.SimpleDateFormat;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Date;

public class ConvertToDay {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String convertUnixToDay(long dt) {
        Date date = new Date(dt*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String formatted = sdf.format(date);
        return formatted;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String convertUnixToFullDate(long dt) {
        Date date = new Date(dt*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("E',' WW.MM.YYYY");
        String formatted = sdf.format(date);
        return formatted;
    }
}
