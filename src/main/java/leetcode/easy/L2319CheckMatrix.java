package leetcode.easy;

//[[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
//[[5,7,0],[0,3,1],[0,5,0]]
public class L2319CheckMatrix {

    public boolean checkXMatrix(int[][] grid) {

        for( int i = 0; i < grid.length; i++ ){
            for( int j = 0; j < grid.length; j++ ){
                if( (i+j == grid.length-1) || i == j ){
                    if( grid[i][j] == 0 ) return false;
                }

                else{
                    if( grid[i][j] != 0 ) return false;
                }
            }
        }

        return true;

    }
}
