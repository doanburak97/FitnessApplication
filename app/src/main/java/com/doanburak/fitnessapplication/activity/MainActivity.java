package com.doanburak.fitnessapplication.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.doanburak.fitnessapplication.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    public static FirebaseAuth mAuth;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        String CHANNEL_ID = "FitnessApp";
        String CHANNEL_NAME = "FitnessApp";
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                CHANNEL_NAME, NotificationManager.IMPORTANCE_LOW);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);

        String message = "Isn't it a great day to work out today?";
        Notification notification = new Notification.Builder(this, CHANNEL_ID)
                .setContentTitle("FitnessApp")
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_baseline_message)
                .setAutoCancel(true)
                .build();
        manager.notify(10, notification);

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