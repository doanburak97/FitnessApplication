package com.doanburak.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class WeatherInfoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp_cities;
    TextView tv_weatherType, tv_temp;
    ImageView iv_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_info);

        sp_cities = findViewById(R.id.sp_cities);
        tv_weatherType = findViewById(R.id.tv_weatherType);
        tv_temp = findViewById(R.id.tv_temp);
        iv_search = findViewById(R.id.iv_search);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_cities.setAdapter(adapter);
        sp_cities.setOnItemSelectedListener(this);

        iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //we call weather API

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