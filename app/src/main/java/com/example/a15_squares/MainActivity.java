package com.example.a15_squares;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Random;

/**
 * Main Activity
 *
 * This main class initializies the board and buttons and creating
 * methods that sets the numbers, shuffles, and checks for the empty
 * button to move round

 *
 * @Author ; Alejandro Varela
 * @Version ; February 23 2023
 */

public class MainActivity extends AppCompatActivity {

    private NumberGrid board;
    private Button[][] buttons;
    private Button randomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Sets the buttons and board
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

       //Calls the randomGen()
       randomGen();
       //Calls the showButton()
       showButton();
       //Sets the onCLickListener to the buttons
       for(int i = 0; i < 4; i++){
           for(int j = 0; j < 4; j++){
               final int row = i;
               final int col = j;
               int newI = i;
               int newJ = j;
               buttons[i][j].setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                      if(isAcrossEmptyButton(row,col)){ //Checks if the empty button is close
                          board.moveButton(row,col, newEmptyRow(), newEmptyCol());
                          showButton();
                          if(board.isSolved()){ //A message pops up with the empty button turning yellow as a sing of it being solved
                              Toast.makeText(MainActivity.this, "YOU SOLVED IT!",
                                      Toast.LENGTH_LONG).show();
                              buttons[newI][newJ].setBackgroundColor(Color.YELLOW);
                          }
                      }
                   }
               });
           }
       }
    }

    //This method checks next to the clicked button if its next to the empty button
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
    //This method shows the buttons on the grid, such as for the shuffle normal in order.
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
    //This method is a row check for the empty button
    private int newEmptyRow(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++) {
                if(board.setButton(i,j) == 0){
                    return i;
                }

            }
        }
        return -1; //Return false when its out of range
    }
    //This method is a column check for the empty button
    private int newEmptyCol(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(board.setButton(i,j) == 0){
                    return j;
                }
            }
        }
        return -1; //Returns false when its out of range
    }
    //This will randomly move the buttons so it can be a puzzle to solve
    private void randomGen(){
        Random random = new Random();

        //Randomly moves the numbers at a certain number of moves
        int randomMove = random.nextInt(50) + 25;
        for(int i = 0; i < randomMove; i++){
            int emptyRow = newEmptyRow();
            int emptyCol = newEmptyCol();

            //Allows the button to be moved using a switch statement
            int direction = random.nextInt(4);
            int buttonRow = emptyRow, buttonCol = emptyCol;
            switch(direction){
                case 0: buttonRow --; break;
                case 1: buttonRow++; break;
                case 2: buttonCol--; break;
                case 3: buttonCol++; break;
            }
            //Checks if the moved button is going out of bounds of the board.
            if(buttonRow >= 0 && buttonRow < 4 && buttonCol >= 0 && buttonCol < 4) {
                board.moveButton(emptyRow, emptyCol, buttonRow, buttonCol);
            }
        }
        showButton();//This will update the board to the randomly generated new board.
    }
    //This method calls the randomGen() if the random button is clicked
    public void onRandomClick(View view){
        randomGen(); //This will randomize the numbers in the grid.
    }

}