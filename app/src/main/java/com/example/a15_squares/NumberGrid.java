package com.example.a15_squares;
import android.graphics.Color;

/**
 * NumberGrid
 *
 * This class updates the board with moving the buttons, gets new buttons,
 * and checks if its solved
 *
 * @Author Alejandro Varela
 * @Version February 24 2023
 */

public class NumberGrid {
        private int[][] button;

        //This represents the grid and how its formated
        public NumberGrid() {
            button = new int[4][4];
            for(int i = 0; i < 4;i++){
                for(int j = 0; j < 4;j++){
                    button[i][j] = i * 4 + j + 1;
                }
            }
            button[3][3]=0;
        }
        //This method gets a button at a certain spot of the board
        public int setButton(int row, int col){
            return button[row][col];
        }
        //This method moves a button to a new part of the board
        public void moveButton(int atRow, int atCol, int toRow, int toCol){
            int cur= button[atRow][atCol];
            button[atRow][atCol] = button[toRow][toCol];
            button[toRow][toCol] = cur;
        }
        //This method checks if the puzzle is solves by checking each button
        public boolean isSolved(){
            for(int i = 0; i < 4;i++){
                for(int j = 0;j < 4;j++){
                    int newValue = i * 4 + j + 1;
                    //Checks a certain part of the board and the bottom corner
                    if(button[i][j] != newValue && !(i == 3 && j == 3
                    && button[i][j] == 0)){
                        return false;
                    }
                }
            }
            return true;
        }
}
