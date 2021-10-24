package codingBlocks.DP;

import java.util.Scanner;


//ros
//horse

public class EditDistance {

    public static void main(String[] args) {
        new EditDistance().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        String word1 = sc.next();
        String word2 = sc.next();

        System.out.println(minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {

        if( word1.length() == 0 ) return word2.length();
        if( word2.length() == 0 ) return word1.length();

        int M = word1.length() + 1;
        int N = word2.length() + 1;



        int[][] dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < N; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if( word1.charAt(i-1) == word2.charAt(j-1) ) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
            }
        }

        return dp[M-1][N-1];
    }
}