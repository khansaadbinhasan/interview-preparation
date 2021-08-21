package DP;

import java.util.*;

//"wfikfadslgjkadsk"
//"ppinuihsuiws"

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        new LongestCommonSubsequence().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        String text1 = sc.next();
        String text2 = sc.next();

        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequenceOld(String text1, String text2) {

        int[][] maxLens = new int[text1.length()][text2.length()];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if( i == 0 || j == 0 ) maxLens[i][j] = text1.charAt(0) == text2.charAt(0) ? 1: 0;
            }
        }

        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if( text1.charAt(i) == text2.charAt(j) ) maxLens[i][j] = maxLens[i][j-1] + 1;
                else maxLens[i][j] = Math.max(maxLens[i][j-1], maxLens[i-1][j]);
            }
        }

        return maxLens[text1.length()-1][text2.length()-1];
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] maxLens = new int[text1.length()+1][text2.length()+1];

        for (int i = 0; i < text1.length(); i++) {
            maxLens[i][0] = 0;
        }

        for (int j = 0; j < text2.length(); j++) {
            maxLens[0][j] = 0;
        }


        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if( text1.charAt(i) == text2.charAt(j) ) maxLens[i+1][j+1] = maxLens[i][j] + 1;
                else maxLens[i+1][j+1] = Math.max(maxLens[i+1][j], maxLens[i][j+1]);
            }
        }

        return maxLens[text1.length()][text2.length()];
    }

}
