package leetcode.medium;

//[[0,1,1,1],[1,1,1,1],[0,1,1,1]]
//[[1,0,1],[1,1,0],[1,1,0]]
//[[1,1,1],[1,1,1]]
//[[1]]
//[[0]]
//[[1,1,1,1,1,1,1],[1,1,1,1,1,1,1],[1,1,1,1,1,1,1],[1,1,1,1,1,1,1],[1,1,1,1,1,1,1]]
//[[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]]
public class L1277SubmatricesWithAllONes {
    public int countSquares(int[][] matrix) {
        int squares = 0;

        for( int i = 0; i < matrix.length; i++ ){
            for( int j = 0; j < matrix[i].length; j++ ){
                if( matrix[i][j] == 1 ) squares++;
                for( int k = 1; i+k < matrix.length && j+k < matrix[i].length; k++ ){
                    if( areAllOnes(matrix, i, j, i+k, j+k) ) {
                        squares++;
                    }
                }
            }
        }

        return squares;
    }

    public boolean areAllOnes(int[][] matrix, int startI, int startJ, int endI, int endJ){
        for( int i = startI; i <= endI; i++ ){
            for( int j = startJ; j <= endJ; j++ ){
                if( matrix[i][j] != 1 ) return false;
            }
        }

        return true;
    }

    public int countSquares2    (int[][] matrix) {
        int squares = 0;

        for( int i = matrix.length-1; i >= 0; i-- ){
            for( int j = matrix[i].length-1; j >= 0; j-- ){
                if( matrix[i][j] == 0 ) continue;
                matrix[i][j] += getMin(matrix, i, j);
                squares += matrix[i][j];
            }
        }

        return squares;
    }

    public int getMin(int[][] matrix, int i, int j){
        int min = Integer.MAX_VALUE;

        if( i+1 < matrix.length && j+1 < matrix[i].length ){
            min = Math.min(matrix[i+1][j], matrix[i][j+1]);
            min = Math.min(min, matrix[i+1][j+1]);
        }

        else{
            min = 0;
        }

        return min;
    }
}
