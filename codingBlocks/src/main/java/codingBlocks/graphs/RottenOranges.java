package codingBlocks.graphs;

import java.util.*;

public class RottenOranges {

    public static void main(String[] args) {
        new RottenOranges().run();
    }

    public void run(){
        Scanner sc =  new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            int[][] grid = new int[m][n];

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {


                    grid[j][k] = sc.nextInt();

//                    System.out.println(grid[j][k]);
                }
            }

            System.out.println(orangesRotting(grid));
        }

    }

    public int orangesRotting(int[][] grid) {

        if( grid.length <= 0 || grid[0].length <= 0 ) return -1;

        Queue<int[]> bfsQ = new LinkedList<>();

        int indM = -1;
        int indN = -1;

        int minutes = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if( grid[i][j] == 2 ){
                    indM = i;
                    indN = j;

                    bfsQ.add(new int[]{i, j, minutes});
                }
            }
        }

        if( indM == -1 && indN == -1 ) return -1;

        while( !bfsQ.isEmpty() ){

            int[] indices = bfsQ.poll();

            indM = indices[0];
            indN = indices[1];
            int count = indices[2];

            minutes = Math.max(minutes, count);

            if( indM < 0 || indN < 0 || indM > grid.length || indN > grid[0].length ) continue;
            if( grid[indM][indN] != 2 ) continue;

            if( indM > 0 && grid[indM-1][indN] == 1 ) {
                grid[indM-1][indN] = 2;
                bfsQ.add(new int[]{indM-1,indN, count+1});
            }

            if( indM < grid.length - 1 && grid[indM+1][indN] == 1 ){
                grid[indM+1][indN] = 2;
                bfsQ.add(new int[]{indM+1, indN, count+1});
            }

            if( indN > 0 && grid[indM][indN-1] == 1 ){
                grid[indM][indN-1] = 2;
                bfsQ.add(new int[]{indM, indN-1, count+1});
            }

            if( indN < grid[0].length - 1 && grid[indM][indN+1] == 1 ){
                grid[indM][indN+1] = 2;
                bfsQ.add(new int[]{indM, indN+1, count+1});
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if( grid[i][j] == 1 ) return -1;
            }
        }

        return minutes;
    }

}
