package leetcode.medium;

import java.util.*;

//3
//7
//3
//2
//1
//1
//10
//10
//10
//1
//1
//10
//7
//3
public class L62UniquePaths {

    int[][] MN;

    public int uniquePaths(int m, int n) {
        MN = new int[m+1][n+1];

        for (int j = 0; j < MN.length; j++) {
            Arrays.fill(MN[j], -1);
        }

        return findPaths(m, n);
    }


    public int findPaths(int m, int n){
        if( m == 1 || n == 1 ) return MN[m][n] = 1;

        if( MN[m-1][n] == -1 ) MN[m-1][n] = findPaths(m-1, n);
        if( MN[m][n-1] == -1 ) MN[m][n-1] = findPaths(m, n-1);

        return MN[m-1][n] + MN[m][n-1];
    }

//     public int uniquePaths(int m, int n) {
//         if( m == 1 || n == 1 ) return 1;

//         return uniquePaths(m-1, n) + uniquePaths(m, n-1);
//     }

    public static void main(String[] args) {
        new L62UniquePaths().run();
    }

    public void run(){
        System.out.println(uniquePathsTD(23, 12));
    }

    public int uniquePaths2(int m, int n) {
        int[][] paths = new int[m+1][n+1];

        paths[1][1] = 1;

        for( int i = 1; i <= m; i++ ){
            for( int j = 1; j <= n; j++ ){
                paths[i][j] += paths[i][j-1];
                paths[i][j] += paths[i-1][j];
            }
        }

        return paths[m][n];
    }

    public int uniquePathsTD(int m, int n) {

        if( m-1 == 0 && n-1 == 0 ) return 1;

        int uniquePaths = 0;

        if( n > 0 ){
            uniquePaths += uniquePaths(m, n-1);
        }

        if( m > 0 ){
            uniquePaths += uniquePaths(m-1, n);
        }

        return uniquePaths;
    }

    int[][] paths;

    public int uniquePathsDPTopDown(int m, int n) {
        paths  = new int[m+1][n+1];
        paths[1][1] = 1;
        return paths(m,n);
    }

    public int paths(int m, int n) {
        if( paths[m][n] != 0 ) return paths[m][n];

        int uniquePaths = 0;

        if( n > 0 ){
            uniquePaths += paths(m, n-1);
        }

        if( m > 0 ){
            uniquePaths += paths(m-1, n);
        }

        return paths[m][n]=uniquePaths;
    }
}
