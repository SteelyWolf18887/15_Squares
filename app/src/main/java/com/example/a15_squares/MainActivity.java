package com.example.a15_squares;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private NumberGrid board;
    private Button[][] buttons;
    private Button randomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       board = new NumberGrid();
       buttons = new Button[4][4];
       buttons[0][0] = findViewById(R.id.b_1);
       buttons[0][1] = findViewById(R.id.b_2);
       buttons[0][2] = findViewById(R.id.b_3);
       buttons[0][3] = findViewById(R.id.b_4);
       buttons[1][0] = findViewById(R.id.b_5);
       buttons[1][1] = findViewById(R.id.b_6);
       buttons[1][2] = findViewById(R.id.b_7);
       buttons[1][3] = findViewById(R.id.b_8);
       buttons[2][0] = findViewById(R.id.b_9);
       buttons[2][1] = findViewById(R.id.b_10);
       buttons[2][2] = findViewById(R.id.b_11);
       buttons[2][3] = findViewById(R.id.b_12);
       buttons[3][0] = findViewById(R.id.b_13);
       buttons[3][1] = findViewById(R.id.b_14);
       buttons[3][2] = findViewById(R.id.b_15);
       buttons[3][3] = findViewById(R.id.b_16);

       randomButton = findViewById(R.id.b_R);

       randomGen();

       showButton();

       for(int i = 0; i < 4; i++){
           for(int j = 0; j < 4; j++){
               final int row = i;
               final int col = j;
               buttons[i][j].setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                      if(isAcrossEmptyButton(row,col)){
                          board.moveButton(row,col, newEmptyRow(), newEmptyCol());
                          showButton();
                          if(board.isSolved()){
                              Toast.makeText(MainActivity.this, "YOU SOLVED IT!",
                                      Toast.LENGTH_LONG).show();
                          }
                      }
                   }
               });
           }
       }
    }

    private boolean isAcrossEmptyButton(int row, int col){
        int emptyButtonRow = newEmptyRow();
        int emptyButtonCol = newEmptyCol();
        for(int i = 0; i < buttons.length; i++){
            for(int j = 0; j < buttons.length; j++){
                if(board.setButton(i,j) == 0){
                    emptyButtonRow = i;
                    emptyButtonCol = j;
                    break;
                }
            }
            if (emptyButtonRow != -1 && emptyButtonCol != -1){
                break;
            }
        }
        return (row == emptyButtonRow && Math.abs(col - emptyButtonCol) == 1) ||
                (col == emptyButtonCol && Math.abs(row - emptyButtonRow) == 1);
    }
    private void showButton(){
        for(int i = 0; i < 4 ; i++){
            for(int j = 0; j < 4; j++) {
                int value = board.setButton(i, j);
                if (value == 0) {
                    buttons[i][j].setText("");
                } else {
                    buttons[i][j].setText(Integer.toString(value));
                }
            }
        }
    }
    private int newEmptyRow(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++) {
                if(board.setButton(i,j) == 0){
                    return i;
                }

            }
        }
        return -1;
    }

    private int newEmptyCol(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(board.setButton(i,j) == 0){
                    return j;
                }
            }
        }
        return -1;
    }

    private void randomGen(){
        Random random = new Random();

        int randomMove = random.nextInt(100) + 100;
        for(int i = 0; i < randomMove; i++){
            int emptyRow = newEmptyRow();
            int emptyCol = newEmptyCol();

            int direction = random.nextInt(4);
            int buttonRow = emptyRow, buttonCol = emptyCol;
            switch(direction){
                case 0: buttonRow --; break;
                case 1: buttonRow++; break;
                case 2: buttonCol--; break;
                case 3: buttonCol++; break;
            }

            if(buttonRow >= 0 && buttonRow < 4 && buttonCol >= 0 && buttonCol < 4) {
                board.moveButton(emptyRow, emptyCol, buttonRow, buttonCol);
            }
        }
        showButton();
    }
    public void onRandomClick(View view){
        randomGen();
    }

}