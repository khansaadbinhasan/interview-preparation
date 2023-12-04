package leetcode.easy;


//[[1,2,3],[4,5,6],[7,8,9]]
//[[1,2,3],[4,5,6]]
//[[1,2,3,5],[4,5,6,9]]
//[[1,2],[4,5],[3,1],[1,1]]
public class L867TransposeMatric {

    public int[][] transpose(int[][] matrix) {

        int[][] transpose = new int[matrix[0].length][matrix.length];

        for( int i = 0; i < matrix.length; i++ ){
            for( int j = 0; j < matrix[i].length; j++ ){
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }
}
