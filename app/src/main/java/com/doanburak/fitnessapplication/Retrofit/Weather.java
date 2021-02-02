package com.doanburak.fitnessapplication.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("main")
    private String main;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @SerializedName("icon")
    private int icon;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
