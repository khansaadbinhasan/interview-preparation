package codingBlocks.arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ValidateSudoku {

    public static void main(String[] args) {
        new ValidateSudoku().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[9][9];

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                board[i][j] = sc.next().charAt(0);

        System.out.println(isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {

            Set<Character> columnSet = new HashSet<>();
            int numDots = 0;

            for (int j = 0; j < 9; j++) {
                if( board[i][j] == '.' ){
                    numDots++;
                    continue;
                }

                columnSet.add(board[i][j]);
            }

            if( columnSet.size() < 9 - numDots ) return false;
        }

        for (int j = 0; j < 9; j++) {

            Set<Character> rowSet = new HashSet<>();
            int numDots = 0;

            for (int i = 0; i < 9; i++) {
                if( board[i][j] == '.' ){
                    numDots++;
                    continue;
                }

                rowSet.add(board[i][j]);
            }

            if( rowSet.size() < 9 - numDots ) return false;
        }

        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                Set<Character> boxSet = new HashSet<>();
                int numDots = 0;

                for (int i = boxRow*3; i < (boxRow+1)*3; i++) {


                    for (int j = boxCol*3; j < (boxCol+1)*3; j++) {
                        if( board[i][j] == '.' ){
                            numDots++;
                            continue;
                        }

                        boxSet.add(board[i][j]);
                    }
                }
                if( boxSet.size() < 9 - numDots ) return false;
            }
        }

        return true;
    }
}