package leetcode.easy;

//[[1,2,3],[4,5,6],[7,8,9]]
//[[1,1,1,1],[1,1,1,1],[1,1,1,1],[1,1,1,1]]
//[[5]]
public class L1572MatrixDiagonalSum {

    public int diagonalSum(int[][] mat) {

        int sum = 0;

        for( int i = 0; i < mat.length; i++ ){
            sum = sum + mat[i][i] + mat[i][mat.length - i - 1];
        }

        int mid = mat.length / 2;

        return sum - (mat.length % 2 == 0 ? 0: mat[mid][mid]);
    }


}
