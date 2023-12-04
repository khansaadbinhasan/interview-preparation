package leetcode.medium;

//[[0,1,1],[1,0,1],[0,0,1]]
//[[1,1,1],[1,1,1]]
//[[1]]
public class L2482DiffZerosOnes {

    public int[][] onesMinusZeros(int[][] grid) {

        int[] onesRow = new int[grid.length];
        int[] onesCol = new int[grid[0].length];
        int[] zeroRow = new int[grid.length];
        int[] zeroCol = new int[grid[0].length];

        int[][] diff = new int[grid.length][grid[0].length];

        for( int i = 0; i < grid.length; i++ ){
            int sumI = 0;
            for( int j = 0; j < grid[i].length; j++ ){
                sumI += grid[i][j];
            }

            onesRow[i] = sumI;
            zeroRow[i] = grid.length-sumI;
        }

        for( int j = 0; j < grid[0].length; j++ ){
            int sumJ = 0;
            for( int i = 0; i < grid.length; i++ ){
                sumJ += grid[i][j];
            }

            onesCol[j] = sumJ;
            zeroCol[j] = grid[0].length-sumJ;
        }

        for( int i = 0; i < grid.length; i++ ){
            for( int j = 0; j < grid[i].length; j++ ){
                diff[i][j] = onesRow[i] + onesCol[j] - zeroRow[i] - zeroCol[j];
            }
        }

        return diff;
    }

}
