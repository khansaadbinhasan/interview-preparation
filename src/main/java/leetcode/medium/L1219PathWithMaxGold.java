package leetcode.medium;

//[[0,6,0],[5,8,7],[0,9,0]]
//[[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
//[[1,2,3],[4,5,6],[7,8,9]]
//[[1]]
//[[0]]
//[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]]
//[[2,0,0,0,0],[0,0,1,0,0],[0,0,0,0,0]]
//[[2,3,4,0,0,0,0,0,0,0,0,0,0,0,10],[2,3,4,0,0,0,0,0,0,0,0,0,0,0,10],[2,3,4,0,0,0,0,0,0,0,0,0,0,0,10],[2,3,4,0,0,0,0,0,0,0,0,0,0,0,10],[2,3,4,0,0,0,0,0,0,0,0,0,0,0,10],[2,3,4,0,0,0,0,0,0,0,0,0,0,0,10],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,10],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]]
//[[1,0,7,0,0,0],[2,0,6,0,1,0],[3,5,6,7,4,2],[4,3,1,0,2,0],[3,0,5,0,20,0]]
public class L1219PathWithMaxGold {
    public static void main(String[] args) {
        new L1219PathWithMaxGold().run();
    }

    public void run(){
        System.out.println(
                getMaximumGold(
                        new int[][]{
                                {1,0,7,0,0,0},
                                {2,0,6,0,1,0},
                                {3,5,6,7,4,2},
                                {4,3,1,0,2,0},
                                {3,0,5,0,20,0}
                        }
                )
        );
    }

    public int getMaximumGold(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxGold = 0;

        for( int i = 0; i < grid.length; i++ ){
            for( int j = 0; j < grid[i].length; j++ ){
                maxGold = Math.max(maxGold, dfs(grid, i, j, visited, 0));
            }
        }

        return maxGold;
    }

    public int dfs(int[][] grid, int i, int j, boolean[][] visited, int currGold){
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || visited[i][j] || grid[i][j] == 0 )
            return currGold;

        visited[i][j] = true;
        currGold+=grid[i][j];
        int up = dfs(grid, i-1, j, visited, currGold);
        int down = dfs(grid, i+1, j, visited, currGold);
        int left = dfs(grid, i, j-1, visited, currGold);
        int right = dfs(grid, i, j+1, visited, currGold);
        visited[i][j] = false;

        int maxGold1 = Math.max(up, down);
        int maxGold2 = Math.max(left, right);

        return Math.max(maxGold1, maxGold2);
    }
}
