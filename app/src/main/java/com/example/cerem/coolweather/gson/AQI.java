package com.example.cerem.coolweather.gson;

/**
 * Created by cerem on 2017-12-15.
 */

public class AQI {

    public AQICity city;

    public class AQICity {
        public String aqi;
        public String pm25;
    }
}
