package leetcode.hard;

import java.util.*;

public class L51NQueens {

    public static void main(String[] args) {
        new L51NQueens().run();
    }

    public void run(){
        System.out.println(solveNQueens2(4));

//        System.out.println(1 + "-->" + solveNQueens(1));//
//        System.out.println(2 + "-->" + solveNQueens(2));
//        System.out.println(3 + "-->" + solveNQueens(3));
//        System.out.println(4 + "-->" + solveNQueens(4));//
//        System.out.println(5 + "-->" + solveNQueens(5));//
//        System.out.println(6 + "-->" +solveNQueens(6));
//        System.out.println(7 + "-->" +solveNQueens(7));//
//        System.out.println(8 + "-->" +solveNQueens(8));
//        System.out.println(9 + "-->" +solveNQueens(9));
    }

//    int[][] board;
//
//    public int solveNQueens(int n) {
//        int maxCount = 0;
//
//        for(int i = 0; i < n; i++){
//            for( int j = 0; j < n; j++ ){
//                board = new int[n][n];
//                maxCount = Math.max(maxCount, count(i,j));
//            }
//        }
//
//        return maxCount;
//    }
//
//    public int count( int x, int y ){
//        int count = 0;
//        for(int i = x; i < board.length; i++){
//            for( int j = y; j < board[i].length; j++ ){
//                if( board[i][j] == 0 ){
//                    set0s(i,j);
//                    count++;
//                }
//            }
//            y=0;
//        }
//
//        return count;
//    }
//
//    public void set0s(int x, int y){
//        for( int i = 0; i < board.length; i++ ){
//            board[i][y] = -1;
//        }
//
//        for( int j = 0; j < board[0].length; j++ ){
//            board[x][j] = -1;
//        }
//
//        int tempX = x;
//        int tempY = y;
//
//        while( x > 0 && y > 0 ) board[--x][--y] = -1;
//        x = tempX; y = tempY;
//        while( x+1 < board.length && y+1 < board[x].length ) board[++x][++y] = -1;
//        x = tempX; y = tempY;
//        while( x > 0 && y+1 < board[x].length ) board[--x][++y] = -1;
//        x = tempX; y = tempY;
//        while( x+1 < board.length && y > 0 ) board[++x][--y] = -1;
//    }

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
