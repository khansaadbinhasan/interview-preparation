package DP;

import java.util.Arrays;
import java.util.Scanner;

public class UniquePaths {

    public static void main(String[] args) {
        new UniquePaths().run();
    }

    int[][] MN;

    public void run(){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            MN = new int[m+1][n+1];

            for (int j = 0; j < MN.length; j++) {
                Arrays.fill(MN[j], -1);
            }

            System.out.println(uniquePaths(m, n));
        }
    }

    public int uniquePaths(int m, int n) {
        if( m == 1 || n == 1 ) {
            return MN[m][n] = 1;
        }

        if( MN[m-1][n] == -1 ) MN[m-1][n] = uniquePaths(m-1, n);
        if( MN[m][n-1] == -1 ) MN[m][n-1] = uniquePaths(m, n-1);

        return MN[m-1][n] + MN[m][n-1];
    }

//    public int uniquePaths(int m, int n) {
//        if( m == 1 || n == 1 ) return 1;
//
//        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
//    }

}
