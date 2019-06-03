package com.example.alicia.openweather.presenter;

import com.example.alicia.openweather.model.Forecast;
import com.example.alicia.openweather.model.NetworkConnection;
import com.example.alicia.openweather.view.ViewContract;

import okhttp3.Cache;

public class Presenter implements PresenterContract{

    private ViewContract view;
    private NetworkConnection network;
    private Forecast dataSet;

    @Override
    public void bind(ViewContract view) {
        this.view = view;
        network = NetworkConnection.getInstance();
    }

    @Override
    public void unbind() {
        view = null;
        dataSet = null;
        network = null;
    }

    @Override
    public void initNetworkConnection(Cache cache) {
        network.setPresenter(this);
        network.initRetrofit(cache);
    }

    @Override
    public void networkSuccessful(Forecast dataSet) {
        view.getForecast(dataSet);
    }

    @Override
    public void networkFailure(String message) {
        view.onError(message);
    }

    @Override
    public void cityName(String name) {
        dataSet.city.name = name;
        view.getCityName(dataSet.city.name);
    }

    @Override
    public void currentTemp(Double temp) {
        dataSet.getList().get(0).main.temp = temp;
        view.getTemp(dataSet.getList().get(0).main.temp);
    }

    @Override
    public void description(String desc) {
        dataSet.getList().get(0).weather.get(0).main = desc;
        view.getDesc(dataSet.getList().get(0).weather.get(0).main);
    }


}
