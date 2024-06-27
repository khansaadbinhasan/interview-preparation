package leetcode.medium;

//[[2,1,3],[6,5,4],[7,8,9]]
//[[-19,57],[-40,-5]]
//[[1]]
//[[1,2],[2,1]]
//[[2,3,4,-5],[12,3,14,-5],[12,-13,14,-5],[12,-13,-14,-5]]
public class L931MinPathFallingSum {
    public int minFallingPathSum(int[][] matrix) {

        for( int i = matrix.length-2; i >= 0; i-- ){
            for( int j = 0; j < matrix[i].length; j++ ){
                int val_1 = j > 0 ? matrix[i+1][j-1]: matrix[i+1][j];
                int val0 = matrix[i+1][j];
                int val1 = j+1 < matrix[i].length ? matrix[i+1][j+1]: matrix[i+1][j];
                matrix[i][j] += Math.min(Math.min(val_1, val0), val1);
            }
        }

        int min = Integer.MAX_VALUE;

        for( int j = 0; j < matrix[0].length; j++ ){
            min = Math.min(min, matrix[0][j]);
        }

        return min;
    }
}
