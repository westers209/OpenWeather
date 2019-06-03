package com.example.alicia.openweather.view;

import com.example.alicia.openweather.model.Forecast;
import com.example.alicia.openweather.model.ListPojo;

public interface ViewContract {
    void populateForecast();
    void onError(String message);
    void bindPresenter();
    void getForecast(Forecast dataSet);
    void getCityName(String name);
    void getTemp(Double temp);
    void getDesc(String desc);
}
