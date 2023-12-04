package leetcode.medium;

//[[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
//[[0,0,0],[0,0,0],[0,0,0]]
//[[1,1], [2,2]]
public class L807MaxIncreaseCitySkuline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int sum = 0;

        for( int i = 0; i < grid.length; i++ ){
            for( int j = 0; j < grid[i].length; j++ ){
                sum += Math.min(getMaxHeightOfRow(grid, i), getMaxHeightOfCol(grid, j)) - grid[i][j];
            }
        }

        return sum;
    }

    public int getMaxHeightOfRow(int[][] grid, int row){

        int maxHeight = grid[row][0];

        for( int j = 1; j < grid[row].length; j++ ){
            maxHeight = Math.max(maxHeight, grid[row][j]);
        }

        return maxHeight;
    }

    public int getMaxHeightOfCol(int[][] grid, int col){
        int maxHeight = grid[0][col];

        for( int i = 1; i < grid.length; i++ ){
            maxHeight = Math.max(maxHeight, grid[i][col]);
        }

        return maxHeight;
    }

}
