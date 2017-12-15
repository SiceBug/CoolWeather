package com.example.cerem.coolweather.util;

import android.text.TextUtils;

import com.example.cerem.coolweather.db.City;
import com.example.cerem.coolweather.db.County;
import com.example.cerem.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by cerem on 2017-12-15.
 */

public class Utility {
    public static boolean handleProvinceResponse(String response) {
        if (TextUtils.isEmpty(response))
            return false;
        try {
            JSONArray allProvinces = new JSONArray(response);
            for (int i = 0; i < allProvinces.length(); i++) {
                JSONObject provinceObject = allProvinces.getJSONObject(i);
                Province province = new Province();
                province.setProvinceName(provinceObject.getString("name"));
                province.setProvinceCode(provinceObject.getInt("id"));
                province.save();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean handleCityResponse(String response, int provinceId) {
        if(TextUtils.isEmpty(response))
            return false;
        try {
            JSONArray allCities = new JSONArray(response);
            for (int i = 0; i < allCities.length(); i++) {
                JSONObject cityObject = allCities.getJSONObject(i);
                City city = new City();
                city.setCityName(cityObject.getString("name"));
                city.setCityCode(cityObject.getInt("id"));
                city.setProvinceId(provinceId);
                city.save();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean handleCountyResponse(String response, int cityId) {
        if(TextUtils.isEmpty(response))
            return false;
        try {
            JSONArray allCounties = new JSONArray(response);
            for (int i = 0; i < allCounties.length(); i++) {
                JSONObject countyObject = allCounties.getJSONObject(i);
                County county = new County();
                county.setCountyName(countyObject.getString("name"));
                county.setWeatherId(countyObject.getString("weather_id"));
                county.setCityId(cityId);
                county.save();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }
}
