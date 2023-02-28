package com.example.test;

public class TimerController implements View.OnClickLidtener{

    TimerModel model;

    TimerController(TimerModel m){
        model = m;
    }

    @Override
    void onCLick(View v){
        watch.start();
    }
}
