package leetcode.medium;

import java.util.*;

//3
//2
//0
//0
//1
//0
//0
//0
public class L688KnightProbabilityInChessboard {

//    int prob = 1;
    List<int[]> knightMoves = Arrays.asList(
            new int[]{2, 1},
            new int[]{2, -1},
            new int[]{1, -2},
            new int[]{1, 2},
            new int[]{-2, 1},
            new int[]{-2, -1},
            new int[]{-1, -2},
            new int[]{-1, 2}
    );

    public double knightProbability(int n, int k, int row, int column) {
        return knightProbability(n, k, row, column, 1);
    }

    public double knightProbability(int n, int k, int row, int column, double prob) {
        if( k == 0 ) return prob;

        int possibleMoves = 0;
        double probability = 0;

        for( int[] moves: knightMoves ){
            if( row + moves[0] < n && row + moves[0] >= 0 && column + moves[1] >= 0 && column + moves[1] < n ){
                possibleMoves++;
                probability += knightProbability(n, k-1, row+moves[0], column+moves[1], prob);
            }
        }

        System.out.println(probability + " " + possibleMoves);

        return probability*(possibleMoves/8.0);
    }


    public static void main(String[] args) {
        new L688KnightProbabilityInChessboard().run();
    }

    public void run(){
        System.out.println(knightProbability(3, 2, 0, 0));
    }
}
