package leetcode.medium;

//[[1,2,3],[4,5,6],[7,8,9]]
//1
//[[1,2,3],[4,5,6],[7,8,9]]
//2
//[[1]]
//1
//[[1,2],[4,5]]
//1
//[[1,2],[4,5]]
//2
//[[1,2,3,4],[4,5,6,7],[7,8,9,10],[7,8,9,10]]
//2
public class L1314MatrixBlockSum {

    public int[][] matrixBlockSum(int[][] mat, int k) {

        int[][] ans = new int[mat.length][mat[0].length];

        for( int i = 0; i < mat.length; i++ ){
            for( int j = 0; j < mat[0].length; j++ ){
                int minI = getMinI(mat, i, k);
                int minJ = getMinJ(mat, j, k);
                int maxI = getMaxI(mat, i, k);
                int maxJ = getMaxJ(mat, j, k);

                int sum = 0;

                for( int l = minI; l <= maxI; l++ ){
                    for( int m = minJ; m <= maxJ; m++ ){
                        sum += mat[l][m];
                    }
                }

                ans[i][j] = sum;
            }
        }

        return ans;

    }

    public int getMaxI(int[][] mat, int i, int k){
        return (i+k)<mat.length? (i+k): mat.length-1;
    }

    public int getMaxJ(int[][] mat, int j, int k){
        return (j+k)<mat[0].length? (j+k): mat[0].length-1;
    }

    public int getMinI(int[][] mat, int i, int k){
        return (i-k)>0? (i-k): 0;
    }

    public int getMinJ(int[][] mat, int j, int k){
        return (j-k)>0? (j-k): 0;
    }


}
