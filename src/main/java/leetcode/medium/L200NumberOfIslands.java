package leetcode.medium;

import java.util.*;

//[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
//[["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
//[["1"]]
//[["0"]]
//[["1","1"]]
public class L200NumberOfIslands {

    class Solution {
        class Land{
            int x;
            int y;
            int dist;

            public Land(int x, int y, int dist){
                this.x = x;
                this.y = y;
                this.dist = dist;
            }
        }

        public int numIslands(char[][] grid) {

            int count = 1;

            for( int i = 0; i < grid.length; i++ ){
                for( int j = 0; j < grid[i].length; j++ ){
                    if( grid[i][j] == '1' ){

                        Queue<Land> bfsQ = new LinkedList<>();

                        bfsQ.offer(new Land(i, j, count));

                        while( !bfsQ.isEmpty() ){

                            Land land = bfsQ.poll();

                            int indI = land.x;
                            int indJ = land.y;

                            if( indI > 0 && grid[indI-1][indJ] == '1' ) {
                                grid[indI-1][indJ] = (char)('1' + count);
                                bfsQ.offer(new Land(indI-1, indJ, count));
                            }

                            if( indI < grid.length-1 && grid[indI+1][indJ] == '1' ){
                                grid[indI+1][indJ] = (char)('1' + count);
                                bfsQ.offer(new Land(indI+1, indJ, count));
                            }

                            if( indJ > 0 && grid[indI][indJ-1] == '1' ) {
                                grid[indI][indJ-1] = (char)('1' + count);
                                bfsQ.offer(new Land(indI, indJ-1, count));
                            }

                            if( indJ < grid[indI].length-1 && grid[indI][indJ+1] == '1' ){
                                grid[indI][indJ+1] = (char)('1' + count);
                                bfsQ.offer(new Land(indI, indJ+1, count));
                            }
                        }

                        count++;
                    }
                }
            }

            return count-1;
        }
    }

    public int numIslandsDFS(char[][] grid) {
        int count = 0;

        for( int i = 0; i < grid.length; i++ ){
            for( int j = 0; j < grid[0].length; j++ ){
                if( grid[i][j] == '1' ){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;

        grid[i][j] = '0';

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    public int numIslandsBFS(char[][] grid) {
        int count = 0;

        for( int i = 0; i < grid.length; i++ ){
            for( int j = 0; j < grid[0].length; j++ ){
                if( grid[i][j] == '1' ){
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void bfs(char[][] grid, int i, int j){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i,j});

        while( !q.isEmpty() ){
            int[] startEnd = q.poll();

            int x = startEnd[0];
            int y = startEnd[1];

            grid[x][y] = '0';

            if( x + 1 < grid.length && grid[x+1][y] == '1' ){
                grid[x+1][y] = '0';
                q.add(new int[]{x+1, y});
            }
            if( x - 1 >= 0 && grid[x-1][y] == '1' ){
                grid[x-1][y] = '0';
                q.add(new int[]{x-1, y});
            }
            if( y + 1 < grid[0].length && grid[x][y+1] == '1' ){
                grid[x][y+1] = '0';
                q.add(new int[]{x, y+1});
            }
            if( y - 1 >= 0 && grid[x][y-1] == '1' ){
                grid[x][y-1] = '0';
                q.add(new int[]{x, y-1});
            }
        }
    }
}
