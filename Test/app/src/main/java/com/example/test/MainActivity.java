package com.example.test;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TimerController controller = new TimerController();
        TimerModel model = new TimerModel();
        setContentView(R.layout.activity_main);
        TextView timer = findViewById(R.id.TimerLabel);
        Button start = findViewbyId(R.id.StartButton);
        StopWatch watch = new StopWatch(timer);
        start.setOnClickListener(new View.OnCLickListener()
        {
            public void onCLick(View v) {
                watch.start();
            }
        });
    }

}