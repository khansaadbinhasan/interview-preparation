package leetcode.easy;

import java.util.PriorityQueue;

//[[1],[22],[333]]
//[[-15,1,3],[15,7,12],[5,6,-2]]
public class L2639FindWidthOfColumnsInGrid {

    public int[] findColumnWidth(int[][] grid) {

        int[] columnLen = new int[grid[0].length];

        for( int i = 0; i < grid[0].length; i++ ){
            int maxLen = String.valueOf(grid[0][i]).length();
            for( int j = 0; j < grid.length; j++ ){
                maxLen = Math.max(maxLen, String.valueOf(grid[j][i]).length());
            }
            columnLen[i] = maxLen;
        }

        return columnLen;

    }
}
