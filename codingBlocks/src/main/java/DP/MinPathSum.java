package DP;

import java.util.Scanner;

public class MinPathSum {

    public static void main(String[] args) {
        new MinPathSum().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] grid = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {

        int M = grid.length;
        int N = grid[0].length;

        int[][] paddedGrid = new int[M+1][N+1];

        for (int i = 0; i <= M; i++) {
            paddedGrid[i][0] = Integer.MAX_VALUE;
        }

        for (int j = 0; j <= N; j++) {
            paddedGrid[0][j] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if( paddedGrid[i-1][j] == Integer.MAX_VALUE && paddedGrid[i][j-1] == Integer.MAX_VALUE ){
                    paddedGrid[i][j] = grid[i-1][j-1];
                }

                else {
                    paddedGrid[i][j] = Math.min(paddedGrid[i-1][j], paddedGrid[i][j-1]) + grid[i-1][j-1];
                }
            }
        }

        return paddedGrid[M][N];
    }

}
