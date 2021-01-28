package com.doanburak.fitnessapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.logout){
            mAuth.signOut();
            Intent toLogin = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(toLogin);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void addTraining(View view){

        Intent toAddTraining = new Intent(MainActivity.this, AddTrainingActivity.class);
        startActivity(toAddTraining);

    }

    public void showTrainings(View view){

        Intent toShowTraining = new Intent(MainActivity.this, ShowTrainingsActivity.class);
        startActivity(toShowTraining);

    }

    public void timekeeper(View view){

        Intent toTimekeeper = new Intent(MainActivity.this, TimekeeperActivity.class);
        startActivity(toTimekeeper);

    }

    public void weatherInfo(View view){

        Intent toWeatherInfo = new Intent(MainActivity.this, WeatherInfoActivity.class);
        startActivity(toWeatherInfo);

    }

    public void userInfo(View view){

        Intent toUserInfo = new Intent(MainActivity.this, UserInfoActivity.class);
        startActivity(toUserInfo);

    }
}