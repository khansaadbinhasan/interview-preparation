package leetcode.medium;

import java.util.*;

//[[1,1,1],[1,0,1],[1,1,1]]
//[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
public class L73SetMatrixToZero {

    public void setZeroes(int[][] matrix) {

        Set<Integer> setI = new HashSet<>();
        Set<Integer> setJ = new HashSet<>();

        for( int i = 0; i < matrix.length; i++ ){
            for( int j = 0; j < matrix[i].length; j++ ){
                if( matrix[i][j] == 0 ){
                    setI.add(i);
                    setJ.add(j);
                }
            }
        }

        for( int i: setI ) setRowToZero(matrix[i]);
        for( int j: setJ ) setColToZero(matrix, j);

    }

    public void setRowToZero(int[] row){
        for( int i = 0; i < row.length; i++ ){
            row[i] = 0;
        }
    }

    public void setColToZero(int[][] matrix, int ind){
        for( int i = 0; i < matrix.length; i++ ){
            matrix[i][ind] = 0;
        }
    }

}
