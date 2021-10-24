package leetcode.easy;

//[[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//[[3,2],[1,0]]
//[[1,-1],[-1,-1]]
//[[-1]]
public class L1351CountNegatives {

    public int countNegatives(int[][] grid) {

        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for( int j = 0; j < grid[i].length; j++ ){
                if( grid[i][j] < 0 ) count++;
            }
        }

        return count;
    }

}
