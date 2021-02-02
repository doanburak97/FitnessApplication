package com.doanburak.fitnessapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.doanburak.fitnessapplication.R;

public class TimekeeperActivity extends AppCompatActivity {

    ImageView iv_restart, iv_start, iv_pause;
    TextView tv_hour, tv_minute, tv_second, tv_MSec;

    Thread threadMSec, threadSecond, threadMinute, threadHour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timekeeper);

        iv_restart = findViewById(R.id.iv_restart);
        iv_start = findViewById(R.id.iv_start);
        iv_pause = findViewById(R.id.iv_pause);
        tv_hour = findViewById(R.id.tv_hour);
        tv_minute = findViewById(R.id.tv_minute);
        tv_second = findViewById(R.id.tv_second);
        tv_MSec = findViewById(R.id.tv_msec);

        Handler updaterMSec = new Handler();
        Handler updaterSecond = new Handler();
        Handler updaterMinute = new Handler();
        Handler updaterHour = new Handler();

        iv_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_hour.setText("00");
                tv_minute.setText("00");
                tv_second.setText("00");
                tv_MSec.setText("00");

            }
        });

        iv_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Thread for MSec
                threadMSec = new Thread(){
                    @Override
                    public void run(){

                        int counter = 1;

                        while(true){

                            if (counter == 99){counter = 0;}

                            try {
                                sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            int finalCounter = counter;
                            updaterMSec.post(new Runnable() {
                                @Override
                                public void run() {
                                    tv_MSec.setText("" + finalCounter);
                                }
                            });

                            counter++;
                        }
                    }
                };
                threadMSec.start();

                //Thread for second
                threadSecond = new Thread(){
                    @Override
                    public void run(){

                        int counter = 1;

                        while(true){

                            if (counter == 60){counter = 0;}

                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            int finalCounter = counter;
                            updaterSecond.post(new Runnable() {
                                @Override
                                public void run() {
                                    tv_second.setText("" + finalCounter);
                                }
                            });

                            counter++;
                        }
                    }
                };
                threadSecond.start();

                //Thread for minute
                threadMinute = new Thread(){
                    @Override
                    public void run(){

                        int counter = 1;

                        while(true){

                            if (counter == 60){counter = 0;}

                            try {
                                sleep(60000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            int finalCounter = counter;
                            updaterMinute.post(new Runnable() {
                                @Override
                                public void run() {
                                    tv_minute.setText("" + finalCounter);
                                }
                            });

                            counter++;
                        }
                    }
                };
                threadMinute.start();

                //Thread for hour
                threadHour = new Thread(){
                    @Override
                    public void run(){

                        int counter = 1;

                        while(true){

                            if (counter == 24){counter = 0;}

                            try {
                                sleep(1440000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            int finalCounter = counter;
                            updaterHour.post(new Runnable() {
                                @Override
                                public void run() {
                                    tv_hour.setText("" + finalCounter);
                                }
                            });

                            counter++;
                        }
                    }
                };
                threadHour.start();

            }
        });

        iv_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                threadMSec.interrupt();
                threadSecond.interrupt();
                threadMinute.interrupt();
                threadHour.interrupt();
            }
        });
    }

}