package com.doanburak.fitnessapplication.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    private String temp;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @SerializedName("feels_like")
    private String feels;

    public String getFeels() {
        return feels;
    }

    public void setFeels(String feels) {
        this.feels = feels;
    }
}
