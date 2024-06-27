package leetcode.blind75;

public class L72EditDistance {

    //     public int minDistance(String word1, String word2) {

//         if( word1.length() == 0 ) return word2.length();
//         if( word2.length() == 0 ) return word1.length();

//         int M = word1.length() + 1;
//         int N = word2.length() + 1;


//         int[][] dp = new int[M][N];

//         for (int i = 0; i < M; i++) {
//             dp[i][0] = i;
//         }

//         for (int j = 0; j < N; j++) {
//             dp[0][j] = j;
//         }

//         for (int i = 1; i < M; i++) {
//             for (int j = 1; j < N; j++) {
//                 if( word1.charAt(i-1) == word2.charAt(j-1) ) dp[i][j] = dp[i-1][j-1];
//                 else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
//             }
//         }

//         return dp[M-1][N-1];
//     }

    public int minDistance(String word1, String word2) {

        return minDistance(new StringBuilder(word1), new StringBuilder(word2), 0, 0, 0);

    }

    public int minDistance(StringBuilder word1, StringBuilder word2, int i, int j, int currDist){

        if( i == word1.length() ) return 0;

        if( word1.charAt(i) == word2.charAt(j) ) return currDist;


        return Math.min(
                Math.min(
                        minDistance( word1.insert(i, word2.charAt(j)), word2, i+1, j+1, currDist+1),
                        minDistance( word1.delete(i,i), word2, i, j+1, currDist+1)
                ),

                minDistance(word1.replace(i, i+1, String.valueOf(word2.charAt(j))),
                        word2, i+1, j+1, currDist+1)
        );

    }

//     public int minDistance(String word1, String word2) {



//     }

    public int minDistance2(String word1, String word2) {

        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for( int i = 0; i < dp.length; i++ ){
            dp[i][0] = i;
        }

        for( int j = 0; j < dp[0].length; j++ ){
            dp[0][j] = j;
        }

        for( int i = 1; i < dp.length; i++ ){
            for( int j = 1; j < dp[0].length; j++ ){
                if( word1.charAt(i-1) == word2.charAt(j-1) ) {
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }

                dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
            }
        }

        return dp[word1.length()][word2.length()];

    }


}
