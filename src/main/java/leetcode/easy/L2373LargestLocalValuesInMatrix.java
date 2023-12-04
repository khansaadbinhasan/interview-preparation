package leetcode.easy;

//[[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
//[[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
public class L2373LargestLocalValuesInMatrix {

    public int[][] largestLocal(int[][] grid) {

        int GRID_SIZE = 3;
        int[][] maxLocal = new int[grid.length - GRID_SIZE+1][grid.length - GRID_SIZE+1];


        for( int i = 0; i < grid.length - GRID_SIZE+1; i++ ){
            for( int j = 0; j < grid[i].length - GRID_SIZE+1; j++ ){
                int max = grid[i][j];

                for(int k = i; k < i + GRID_SIZE; k++){
                    for(int l = j; l < j + GRID_SIZE; l++){
                        max = Math.max(max, grid[k][l]);
                    }
                }

                maxLocal[i][j] = max;
            }
        }

        return maxLocal;
    }
}
