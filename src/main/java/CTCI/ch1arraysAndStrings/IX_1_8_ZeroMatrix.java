package CTCI.ch1arraysAndStrings;

import java.util.HashSet;
import java.util.Set;

public class IX_1_8_ZeroMatrix {

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
