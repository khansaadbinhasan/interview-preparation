package leetcode.medium;


//[[0,0,0],[0,1,0],[0,0,0]]
//[[0,1],[0,0]]
//[[0]]
//[[0,0]]
//[[0,0],[0,0]]
//[[1]]
//[[0,1]]
//[[1,1,1],[0,0,0]]
public class L63UniquePaths {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if( obstacleGrid[0][0] == 1 ) return 0;

        int[][] numPaths = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];

        numPaths[1][1] = 1;

        for( int i = 1; i < numPaths.length; i++ ){
            for( int j = 1; j < numPaths[i].length; j++ ){
                if( i == 1 && j == 1 ) continue;
                if( obstacleGrid[i-1][j-1] == 1 ) {
                    numPaths[i][j] = 0;
                    continue;
                }

                numPaths[i][j] = numPaths[i-1][j] + numPaths[i][j-1];//down+right
            }
        }

        return numPaths[obstacleGrid.length][obstacleGrid[0].length];

    }

}
