package leetcode.easy;

//[1,2,3,4]
//2
//2
//[1,2,3]
//1
//3
//[1,2]
//1
//1
public class L2022ConvertArray {

    public int[][] construct2DArray(int[] original, int m, int n) {

        if( m * n != original.length ) return new int[][]{};

        int[][] twoDArr = new int[m][n];

        for( int j = 0; j < m; j++ ){
            for( int i = 0; i < n; i++ ){
                twoDArr[j][i] = original[j*n+i];
            }
        }

        return twoDArr;
    }
}
