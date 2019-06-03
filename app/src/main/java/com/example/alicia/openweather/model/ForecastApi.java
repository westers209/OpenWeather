package com.example.alicia.openweather.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ForecastApi {
    int zip = 30345;
    String units = "imperial";
    @GET("forecast?zip="+zip+"&units="+units+"&APPID=0407edd6e9d500c1b27e8ac8c380a3f5")
    Call<Forecast> getForecast();
}
