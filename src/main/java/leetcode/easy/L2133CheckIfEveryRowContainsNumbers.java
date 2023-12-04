package leetcode.easy;

import java.util.*;

//[[1,2,3],[3,1,2],[2,3,1]]
//[[1,1,1],[1,2,3],[1,2,3]]
//[[1]]
//[[1,1],[2,2]]
//[[1,2],[2,1]]
public class L2133CheckIfEveryRowContainsNumbers {

    public boolean checkValid(int[][] matrix) {
        Set<Integer> nSet = new HashSet<>();

        for( int i = 1; i <= matrix.length; i++ ){
            nSet.add(i);
        }

        for( int i = 0; i < matrix.length; i++ ){
            if( !containsAll(matrix, nSet, i, -1) ) return false;
        }

        for( int j = 0; j < matrix.length; j++ ){
            if( !containsAll(matrix, nSet, -1, j) ) return false;
        }

        return true;
    }

    public boolean containsAll(int[][] matrix, Set<Integer> nSet, int row, int col){

        Set<Integer> currSet = new HashSet<>();

        if( col == -1 ){
            for( int j = 0; j < matrix[row].length; j++ ){
                currSet.add(matrix[row][j]);
            }

            return currSet.equals(nSet);
        }

        if( row == -1 ){
            for( int i = 0; i < matrix.length; i++ ){
                currSet.add(matrix[i][col]);
            }

            return currSet.equals(nSet);
        }

        return false;
    }
}
