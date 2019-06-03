package com.example.alicia.openweather.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alicia.openweather.R;

class ForecastViewHolder extends RecyclerView.ViewHolder {
    TextView tv_date;
    TextView tv_temperature;
    ImageView iv_icon;

    ForecastViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_date = itemView.findViewById(R.id.tv_date);
        tv_temperature = itemView.findViewById(R.id.tv_temperature);
        iv_icon = itemView.findViewById(R.id.iv_icon);
    }
}
