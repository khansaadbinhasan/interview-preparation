package leetcode.easy;

//[[1,2],[3,4]]
//[[2]]
//[[1,0],[0,2]]
//[[1,1,1],[1,0,1],[1,1,1]]
//[[2,2,2],[2,1,2],[2,2,2]]
public class L883ProjectionOf3DShapes {

    public int projectionArea(int[][] grid) {

        int area = 0;

        for( int i = 0; i < grid.length; i++ ){
            for( int j = 0; j < grid[i].length; j++ ){
                if( grid[i][j] != 0 ) area++;
            }
        }



        for( int i = 0; i < grid.length; i++ ){
            area += findMaxRow(grid[i]) + findMaxCol(grid, i);
        }

        return area;
    }

    public int findMaxRow(int[] nums){

        int max = nums[0];

        for(int num: nums){
            max = Math.max(max, num);
        }

        return max;
    }

    public int findMaxCol(int[][] mat, int col){

        int max = mat[0][col];

        for(int i = 1; i < mat.length; i++){
            max = Math.max(max, mat[i][col]);
        }

        return max;
    }

}
