package leetcode.easy;

//[[1,2],[3,4]]
//1
//4
//[[1,2],[3,4]]
//2
//4
//[[1,2],[3,4]]
//4
//1
public class L566ReshapeMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        if( r*c != mat.length*mat[0].length ) return mat;

        int[][] reshaped = new int[r][c];

        int[] arr = new int[r*c];
        int k = 0;

        for( int i = 0; i < mat.length; i++ ){
            for( int j = 0; j < mat[i].length; j++ ){
                arr[k++] = mat[i][j];
            }
        }

        k = 0;
        int l = 0;
        for( int i = 0; i < arr.length; i++ ){
            if( k < r && l < c ){
                reshaped[k][l++] = arr[i];
            }

            else if( l >= c && k < r ){
                l = 0;
                k++;
                i--;
            }

            else return reshaped;
        }

        return reshaped;
    }
}
