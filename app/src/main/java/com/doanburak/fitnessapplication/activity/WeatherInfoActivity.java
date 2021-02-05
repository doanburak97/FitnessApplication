package com.doanburak.fitnessapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.doanburak.fitnessapplication.R;
import com.doanburak.fitnessapplication.Retrofit.ApiClient;
import com.doanburak.fitnessapplication.Retrofit.ApiInterface;
import com.doanburak.fitnessapplication.Retrofit.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherInfoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView tv_feels, tv_temp;
    ImageView iv_search;
    ImageView iv_weatherIcon;
    Spinner sp_cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_info);

        sp_cities = findViewById(R.id.sp_cities);
        tv_temp = findViewById(R.id.tv_temp);
        tv_feels = findViewById(R.id.tv_feels);
        iv_search = findViewById(R.id.iv_search);
        iv_weatherIcon = findViewById(R.id.iv_weatherIcon);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_cities.setAdapter(adapter);
        sp_cities.setOnItemSelectedListener(this);

        iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //we call weather API
                getWeatherData(sp_cities.getSelectedItem().toString().trim());

            }
        });


    }

    //Calculate Kelvin To Degree
    private float convertKToC(float temp){

        float result = (float)(temp - 272.15);
        return result;

    }

    private void getWeatherData(String name){

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                float convertedTemp = Math.round(convertKToC(Float.valueOf(response.body().getMain().getTemp())));
                float convertedFeels = Math.round(convertKToC(Float.valueOf(response.body().getMain().getFeels())));

                tv_temp.setText("Temperature : " + String.valueOf(convertedTemp) + " 'C");
                tv_feels.setText("Feels Like : " + String.valueOf(convertedFeels) + " 'C");

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(WeatherInfoActivity.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}