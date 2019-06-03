package com.example.alicia.openweather.view;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alicia.openweather.R;
import com.example.alicia.openweather.model.City;
import com.example.alicia.openweather.model.Forecast;
import com.example.alicia.openweather.presenter.Presenter;

import okhttp3.Cache;

public class MainActivity extends AppCompatActivity implements ViewContract {

    private static final String TAG = "MainActivity";
    private Presenter presenter;
    private ForecastAdapter adapter;
    private RecyclerView recyclerView;
    private TextView tv_city, tv_now_temp, tv_description;
    private ImageButton settings;
    private boolean settingsDisplayed = false;
    private Forecast forecast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        bindPresenter();

        adapter = new ForecastAdapter();
        adapter.setHasStableIds(true);
        recyclerView = findViewById(R.id.rv_main_list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setHasFixedSize(true); //Helps rendering by saying the data set's size will never change.
        recyclerView.setAdapter(adapter);

        populateForecast();

        tv_city = findViewById(R.id.tv_city);
        tv_now_temp = findViewById(R.id.tv_now_temp);
        tv_description = findViewById(R.id.tv_description);
 //       getCityName(forecast.city.name);

    }


    @Override
    public void populateForecast() {
        if (hasNetwork()) {
            long cacheSize = (5 * 1024 * 1024);
            Cache myCache = new Cache(getCacheDir(), cacheSize);
            presenter.initNetworkConnection(myCache);
        } else {
            onError("No network found");
        }
    }

    boolean hasNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    @Override
    public void onError(String message) {
        Log.e(TAG, message);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void bindPresenter() {
        presenter = new Presenter();
        presenter.bind(this);
    }

    @Override
    public void getForecast(Forecast dataSet) {
        adapter.setDataSet(dataSet);
    }

    @Override
    public void getCityName(String name) {
        presenter.cityName(name);
        tv_city.setText(name);
    }

    @Override
    public void getTemp(Double temp) {
        tv_now_temp.setText(temp.toString());
    }

    @Override
    public void getDesc(String desc) {
        tv_description.setText(desc);
    }
}
