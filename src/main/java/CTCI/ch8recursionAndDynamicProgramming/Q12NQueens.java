package CTCI.ch8recursionAndDynamicProgramming;

import java.util.*;

public class Q12NQueens {

    public static void main(String[] args) {
        new Q12NQueens().run();
    }

    public void run(){
//        System.out.println(solveNQueens(4));
        ArrayList<Integer[]> results = new ArrayList<>();
//        System.out.println(placeQueens(0,new Integer[]{}, results));

        System.out.println(results);
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> solutions = new LinkedList<>();

        for( int j = 0; j < n; j++ ){
            List<String> queens = placeQueens(0,j,n);
            if( !queens.isEmpty() )
                solutions.add(queens);
        }

        return solutions;
    }

    public List<String> placeQueens(int x, int y, int n){
        int numQs = 0;

        char[][] solution = new char[n][n];

        for( int i = 0; i < n; i++ ){
            for( int j = 0; j < n; j++ ){
                solution[i][j] = 'E';//E symbolize empty cell
            }
        }

        for( int i = x; i < n; i++ ){
            for( int j = (i == x? y: 0); j < n; j++ ){
                if( solution[i][j] == 'E' ){
                    solution[i][j] = 'Q';
                    fillDots(solution, i, j, n);
                    numQs++;
                }
            }
        }

        List<String> board = new LinkedList<>();

        for( int i = 0; i < n; i++ ){
            board.add(new String(solution[i]));
        }

        return numQs == n? board: new LinkedList<>();
    }

    public void fillDots(char[][] board, int x, int y, int n){

        for( int i = 0; i < board.length; i++ ){
            if( board[i][y] == 'E' ) board[i][y] = '.';
        }

        for( int j = 0; j < board[x].length; j++ ){
            if( board[x][j] == 'E' ) board[x][j] = '.';
        }

        int i = x;
        int j = y;

        while( i >= 0 && j >= 0 ){
            if( board[i][j] == 'E' ) board[i][j] = '.';
            i--; j--;
        }

        i = x;
        j = y;

        while( i < n && j < n ){
            if( board[i][j] == 'E' ) board[i][j] = '.';
            i++;j++;
        }

        i = x;
        j = y;

        while( i >= 0 && j < n ){
            if( board[i][j] == 'E' ) board[i][j] = '.';
            i--;j++;
        }

        i = x;
        j = y;

        while( i < n && j >= 0 ){
            if( board[i][j] == 'E' ) board[i][j] = '.';
            i++;j--;
        }

    }


    int GRID_SIZE = 8;

    void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results){
        if( row == GRID_SIZE ) results.add(columns.clone());
        else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if( checkValid(columns, row, col) ){
                    columns[row] = col;
                    placeQueens(row+1, columns, results);
                }
            }
        }
    }

    boolean checkValid(Integer[] columns, int row1, int columns1){
        for (int row2 = 0; row2 < row1; row2++) {
            int column2 = columns[row2];
            if( columns1 == column2 ) return false;

            int columnDistance = Math.abs(column2-columns1);
            int rowDistance = row1-row2;
            if( columnDistance == rowDistance ) return false;
        }

        return false;
    }

    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>(); // r+c
    Set<Integer> negDiag = new HashSet<>(); // r-c

    List<List<String>> res;
    char[][] board;
    int n;

    public List<List<String>> solveNQueens2(int num) {
        res = new LinkedList<>();
        n = num;
        board = new char[n][n];

        for( int i = 0; i < n; i++ ){
            for( int j = 0; j < n; j++ ){
                board[i][j] = '.';
            }
        }

        backtrack(0);

        return res;
    }

    public void backtrack(int r){
        if( r == n ) {
            List<String> copy = new LinkedList<>();

            for( int i = 0; i < n; i++ ){
                copy.add(new String(board[i]));
            }

            res.add(copy);

            return;
        }

        for( int j = 0; j < n; j++ ){
            int c = j;
            if( col.contains(j) || posDiag.contains(r+c) || negDiag.contains(r-c) ) continue;

            col.add(j);
            posDiag.add(r+c);
            negDiag.add(r-c);
            board[r][c] = 'Q';

            backtrack(r+1);

            col.remove(j);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            board[r][c] = '.';
        }
    }

}
