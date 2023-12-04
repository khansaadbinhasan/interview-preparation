package leetcode.easy;

//[[1,0,0],[0,0,1],[1,0,0]]
//[[1,0,0],[0,1,0],[0,0,1]]
//[[0,0,0,1],[1,0,0,0],[0,1,1,0],[0,0,0,0]]
//[[0,0,0,0,0],[1,0,0,0,0],[0,1,0,0,0],[0,0,1,0,0],[0,0,0,1,1]]
public class L1582SpecialPositionInBinaryMatrix {

    public int numSpecial(int[][] mat) {

        int[] rowsIndices = new int[mat.length];

        for( int i = 0; i < mat.length; i++ ){
            if(sumArr(mat[i]) == 1) rowsIndices[i] = 1;
        }

        int count = 0;

        for( int j = 0; j < mat[0].length; j++ ){
            if( sumCol(mat, j) == 1 ){
                for( int i = 0; i < mat.length; i++ ){
                    if( mat[i][j] == 1 && rowsIndices[i] == 1) count++;
                }
            }
        }

        return count;

    }

    public int sumArr(int[] arr){

        int sum = 0;

        for( int i: arr ) sum += i;

        return sum;
    }

    public int sumCol(int[][] mat, int ind){

        int sum = 0;

        for( int i = 0; i < mat.length; i++ ){
            sum += mat[i][ind];
        }

        return sum;

    }

}
