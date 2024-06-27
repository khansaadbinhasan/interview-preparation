package leetcode.blind75;

import java.util.HashSet;
import java.util.Set;

//[[1,1,1],[1,0,1],[1,1,1]]
//[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//[[1,1],[2,2]]
//[[1,0],[0,1],[2,2]]
//[[0,0,0],[1,1,1]]
//[[1,1,1,0],[0,1,1,1]]
//[[1]]
//[[1,1],[2,2],[0,1]]
public class L73SetMatrixToZero {

    public static void main(String[] args) {
        new L73SetMatrixToZero().run();
    }

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

    public void run(){
        setZeroesII(new int[][]{{1,1,1,0},{0,1,1,1}});
    }

    public void setZeroesII(int[][] matrix) {

        boolean isZero = false;

        for(int i = 0; i < matrix.length; i++){
            if( matrix[i][0] == 0 ) isZero = true;
        }

        for( int i = 0; i < matrix.length; i++ ){
            for( int j = 1; j < matrix[i].length; j++ ){
                if( matrix[i][j] == 0 ){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for( int j = 1; j < matrix[0].length; j++ ){
            if( matrix[0][j] == 0 ) setColToZero(matrix, j);
        }

        for( int i = 0; i < matrix.length; i++ ){
            if( matrix[i][0] == 0 ) setRowToZero(matrix[i]);
        }

        if( isZero ){
            setColToZero(matrix, 0);
        }

    }

}
