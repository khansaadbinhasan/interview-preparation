package codingBlocks.graphs;

import java.util.*;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        new MaxAreaOfIsland().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxAreaOfIsland(grid));
    }

    class Land{
        int x;
        int y;
        int id;

        public Land(int x, int y, int id){
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if( grid[i][j] != 1 ) continue;

                Queue<Land> bfsQ = new LinkedList<>();

                bfsQ.offer(new Land(i, j, 1));

                int count = 1;

                while( !bfsQ.isEmpty() ){

                    Land land = bfsQ.poll();

                    int landX = land.x;
                    int landY = land.y;
                    int landId = land.id;

                    grid[landX][landY] += landId;

                    if( landX > 0 && grid[landX-1][landY] == 1 ) {
                        grid[landX-1][landY] += landId;
                        bfsQ.offer(new Land(landX-1, landY, landId));

                        count++;
                    }

                    if( landX < grid.length-1 && grid[landX+1][landY] == 1 ) {
                        grid[landX+1][landY] += landId;
                        bfsQ.offer(new Land(landX+1, landY, landId));

                        count++;
                    }

                    if( landY > 0 && grid[landX][landY-1] == 1 ) {
                        grid[landX][landY-1] += landId;
                        bfsQ.offer(new Land(landX, landY-1, landId));

                        count++;
                    }

                    if( landY < grid[i].length-1 && grid[landX][landY+1] == 1 ) {
                        grid[landX][landY+1] += landId;
                        bfsQ.offer(new Land(landX, landY+1, landId));

                        count++;
                    }
                }

                maxArea = Math.max(maxArea, count);
            }
        }

        return maxArea;
    }

}
