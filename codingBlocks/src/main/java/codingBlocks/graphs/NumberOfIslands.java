package codingBlocks.graphs;

import java.util.*;

public class NumberOfIslands {
    public static void main(String[] args) {
        new NumberOfIslands().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            grid[i] = sc.next().toCharArray();
        }

        System.out.println(numIslands(grid));
    }

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
