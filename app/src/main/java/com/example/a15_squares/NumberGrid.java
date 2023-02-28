package com.example.a15_squares;

public class NumberGrid {
        private int[][] button;

        public NumberGrid() {
            button = new int[4][4];
            for(int i = 0; i < 4;i++){
                for(int j = 0; j < 4;j++){
                    button[i][j] = i * 4 + j + 1;
                }
            }
            button[3][3]=0;
        }
        public int setButton(int row, int col){
            return button[row][col];
        }

        public void moveButton(int atRow, int atCol, int toRow, int toCol){
            int cur= button[atRow][atCol];
            button[atRow][atCol] = button[toRow][toCol];
            button[toRow][toCol] = cur;
        }

        public boolean isSolved(){
            for(int i = 0; i < 4;i++){
                for(int j = 0;j < 4;j++){
                    int newValue = i * 4 + j + 1;
                    if(button[i][j] != newValue && !(i == 3 && j == 3
                    && button[i][j] == 0)){
                        return false;
                    }
                }
            }
            return true;
        }
}
