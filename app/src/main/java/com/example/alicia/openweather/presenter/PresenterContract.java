package com.example.alicia.openweather.presenter;

import com.example.alicia.openweather.model.Forecast;
import com.example.alicia.openweather.view.ViewContract;

import okhttp3.Cache;

public interface PresenterContract {
    void bind(ViewContract view);

    void unbind();

    void initNetworkConnection(Cache cache);

    void networkSuccessful(Forecast dataSet);

    void networkFailure(String message);

    void cityName(String name);

    void currentTemp(Double temp);

    void description(String desc);

}
