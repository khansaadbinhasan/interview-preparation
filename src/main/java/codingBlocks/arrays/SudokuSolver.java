package codingBlocks.arrays;

import java.util.Scanner;

public class SudokuSolver {

    public static void main(String[] args) {
        new SudokuSolver().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] sudokuArr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sudokuArr[i][j] = sc.nextInt();
            }
        }

        solveSudoku(sudokuArr, 0, 0, N);

        System.out.println();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sudokuArr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean solveSudoku(int[][] sudokuArr, int i, int j, int N){

        if( i == N ) return true;
        if( j == N ) return solveSudoku(sudokuArr, i+1, 0, N);

        if( sudokuArr[i][j] != 0 ) return solveSudoku(sudokuArr, i, j+1, N);

        for (int number = 1; number <= N; number++) {
            if( isSafeToPut(sudokuArr, i, j, number) ){
                sudokuArr[i][j] = number;
                boolean isSudokuSolved = solveSudoku(sudokuArr, i, j+1, N);
                if( isSudokuSolved ) return true;
                sudokuArr[i][j] = 0;
            }
        }

        return false;
    }

    public boolean isSafeToPut(int[][] sudokuArr, int i, int j, int number){

        int N = sudokuArr.length;

        for (int k = 0; k < N; k++) {
            if( k == i ) continue;
            if( number == sudokuArr[k][j] ) return false;
        }

        for (int k = 0; k < N; k++) {
            if( k == j ) continue;
            if( number == sudokuArr[i][k] ) return false;
        }

        int sqrtN = (int) Math.sqrt(N);
        int newI = (i / sqrtN) * sqrtN;
        int newJ = (j / sqrtN) * sqrtN;

        for (int k = newI; k < newI + sqrtN; k++) {
            for (int l = newJ; l < newJ + sqrtN; l++) {
                if( k == i && l == j ) continue;
                if( number == sudokuArr[k][l] ) return false;
            }
        }

        return true;
    }

}
