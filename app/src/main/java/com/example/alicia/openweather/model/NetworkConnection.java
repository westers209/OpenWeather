package com.example.alicia.openweather.model;

import com.example.alicia.openweather.presenter.Presenter;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkConnection {

    private NetworkConnection() {
    }

    private static NetworkConnection instance;
    private static Presenter presenter;

    Callback<Forecast> callback = new Callback<Forecast>() {
        @Override
        public void onResponse(Call<Forecast> call, Response<Forecast> response) {
            if (response.isSuccessful() && response != null) {
                presenter.networkSuccessful(response.body());

            }
        }

        @Override
        public void onFailure(Call<Forecast> call, Throwable t) {
            presenter.networkFailure(t.getMessage());
        }
    };

    public static NetworkConnection getInstance() {
        if (instance == null) {
            instance = new NetworkConnection();
        }
        return instance;
    }

    public void setPresenter(Presenter presenter) {
        instance.presenter = presenter;
    }

    public void initRetrofit(Cache cache) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();
        new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ForecastApi.class)
                .getForecast()
                .enqueue(callback);
    }
}
