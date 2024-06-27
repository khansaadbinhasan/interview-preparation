package leetcode.medium;

public class L1020NumberOfEnclaves {

    boolean[][] visited;
    boolean[][] canGo;

    public int numEnclaves(int[][] grid) {
        int count = 0;
        int count1s = 0;

        canGo = new boolean[grid.length][grid[0].length];

        for( int i = 0; i < grid.length; i++ ){
            for( int j = 0; j < grid[i].length; j++ ){
                if( grid[i][j] == 1 ) {
                    visited = new boolean[grid.length][grid[0].length];
                    count1s++;
                    if( dfs(grid, i,j) ) count++;
                }
            }
        }

        return count1s-count;
    }

    public boolean dfs(int[][] grid, int i, int j){
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[i].length ) return false;
        if( grid[i][j] == 0 ) return false;
        if( canGo[i][j] ) return true;
        if(i == 0 || i == grid.length-1 || j == 0 || j == grid[i].length-1) return true;

        visited[i][j] = true;

        if( i+1 < grid.length && !visited[i+1][j] ) if( dfs(grid, i+1, j) ) return canGo[i][j] = true;
        if( j+1 < grid[0].length && !visited[i][j+1] ) if( dfs(grid, i, j+1) ) return canGo[i][j] = true;
        if( i-1 >= 0 && !visited[i-1][j] ) if( dfs(grid, i-1, j) ) return canGo[i][j] = true;

        return canGo[i][j] = dfs(grid, i, j - 1);
    }
    public static void main(String[] args) {
        new L1020NumberOfEnclaves().run();
    }

    public void run(){
        int[][] grid = new int[][]{
                {0,1,1,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,0}
        };

        System.out.println(numEnclaves(grid));
    }

}
