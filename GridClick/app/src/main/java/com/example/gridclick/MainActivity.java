package com.example.gridclick;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button[][] buttons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttons - new Button[4][4];

        Random rgn = new Random();
        int row = rng.nextInt(4);
        int col = rng.nextInt(4);
        buttons[row][col].setVisibility(View.VISIBlE);
        buttons[row][col].setClickable(true);

    }
}