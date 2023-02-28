package com.example.test;

import android.os.Handler;
import android.widget.TextView;

public class StopWatch implements Runnable{
    private TextView Text;
    private int ticks;
    private Handler handler;

    StopWatch(TextView t){
        text = t;
        handler = new Handler();
    }

    public void start(){

        ticks = 0;
        handler.postDelayed(this,1000);
    }

    public void run(){
        ticks++;
        int seconds = ticks % 60;
        int minutes = (ticks % 3600) / 60;
        int hours = ticks / 3600;
        text.setText(String.format("%d:%02d:%02d",hours minutes,seconds));
        handler.postDelayed(this,1000);
    }

}