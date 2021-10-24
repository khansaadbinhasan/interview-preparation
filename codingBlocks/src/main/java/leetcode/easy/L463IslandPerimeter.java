package leetcode.easy;

//[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
//[[1]]
//[[1,0]]
public class L463IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        int perimeter = 0;

        for( int i = 0; i < grid.length; i++ ){
            for( int j = 0; j < grid[i].length; j++ ){

                if( grid[i][j] == 1 ) {

                    int perim = 0;

                    if( !(i > 0 && grid[i-1][j] == 1) ) perim++;
                    if( !(i < grid.length-1 && grid[i+1][j] == 1) ) perim++;
                    if( !(j > 0 && grid[i][j-1] == 1) ) perim++;
                    if( !(j < grid[i].length-1 && grid[i][j+1] == 1) ) perim++;


                    perimeter += perim;
                }
            }
        }

        return perimeter;
    }

}
