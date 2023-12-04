package misc.advancedRecursion;

public class NQueenProblem {

    public static void main(String[] args) {
        new NQueenProblem().run();
    }

    int N = 4;

    public void run(){



    }

    public boolean nQueen(int board[][], int row){

        if( row == N ) return true;

        for (int col = 0; col < N; col++) {

            if( isSafe(board, row, col) ){

                board[row][col] = 1;

                if( nQueen(board, row+1) ) return true;

                board[row][col] = 0;
            }
        }

        return false;

    }

    public boolean isSafe(int[][] board, int row, int col){
        return true;
    }
}
