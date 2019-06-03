package com.example.alicia.openweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {
    public String main;
    @SerializedName("icon")
    @Expose
    private String icon;

    public String getIcon() {
        return "http://openweathermap.org/img/w/"+icon+".png";
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
