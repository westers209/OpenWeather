package com.example.alicia.openweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Forecast {
    @SerializedName("list")
    @Expose
    private ArrayList<ListPojo> list;

    public ArrayList<ListPojo> getList() {
        return list;
    }

    public void setList(ArrayList<ListPojo> list) {
        this.list = list;
    }

    public City city;

}
