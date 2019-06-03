package com.example.alicia.openweather.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.alicia.openweather.R;
import com.example.alicia.openweather.model.Forecast;
import com.squareup.picasso.Picasso;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastViewHolder> {

    Forecast dataSet;

    public void setDataSet(Forecast data) {
        this.dataSet = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ForecastViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder ForecastViewHolder, int i) {
        ForecastViewHolder.tv_date.setText(dataSet.getList().get(i).dt_txt);
        ForecastViewHolder.tv_temperature.setText(dataSet.getList().get(i).main.temp.toString());
        Picasso.get().load(dataSet.getList().get(i).weather.get(0).getIcon()).into(ForecastViewHolder.iv_icon);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.getList().size() : 0;
    }
}
