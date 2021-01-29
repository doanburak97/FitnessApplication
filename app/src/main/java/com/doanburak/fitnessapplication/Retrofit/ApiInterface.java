package com.doanburak.fitnessapplication.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("weather?&appid=33751e1f5b6103eb0b7003bfcd90e17b")
    Call<Example> getWeatherData(@Query("q") String name);
}
