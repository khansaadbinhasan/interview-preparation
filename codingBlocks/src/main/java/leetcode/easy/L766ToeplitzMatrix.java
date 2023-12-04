package leetcode.easy;


//[[1,2,3,4],[5,1,2,3],[9,5,1,2]]
//[[1,2],[2,2]]
public class L766ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {

        // for( int i = 0, j = 0; i < matrix.length, j < matrix[i].length; i++ ){
        for( int j = 0; j < matrix[0].length; j++ ){
            int indI = 0;
            int indJ = j;

            int val = matrix[indI][indJ];

            while( indI < matrix.length && indJ < matrix[0].length ){
                if( val != matrix[indI++][indJ++] ) return false;
            }
        }

        for( int i = 1; i < matrix.length; i++ ){
            int indI = i;
            int indJ = 0;

            int val = matrix[indI][indJ];

            while( indI < matrix.length && indJ < matrix[i].length ){
                if( val != matrix[indI++][indJ++] ) return false;
            }
        }


        return true;
    }

}
