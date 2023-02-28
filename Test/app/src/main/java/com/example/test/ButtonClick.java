package com.example.test;

import android.view.view;
import android.widget.TextView;

public class ButtonClick implements View.OnClickListener {

    TextView timer;
    public ButtonClick(TextVIew t){
        timer = t;
    }

    public void onClick(View v){
        timer.setText("1:00:00");
    }
}
