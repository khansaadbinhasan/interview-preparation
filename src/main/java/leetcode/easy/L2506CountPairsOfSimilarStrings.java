package leetcode.easy;

import java.util.*;

//["aba","aabb","abcd","bac","aabc"]
//["aabb","ab","ba"]
//["nba","cba","dba"]
public class L2506CountPairsOfSimilarStrings {

    public int similarPairs(String[] words) {

        int count = 0;
        int[][] arrfreqArr = new int[words.length][26];

        for( int i = 0; i < words.length; i++ ){
            arrfreqArr[i] = freqArr(words[i]);
        }

        for( int i = 0; i < words.length; i++ ){
            for( int j = i+1; j < words.length; j++ ){
                if( Arrays.equals(arrfreqArr[i], arrfreqArr[j]) ){
                    count++;
                }
            }
        }

        return count;
    }

    public int[] freqArr(String word){

        int[] freqArr = new int[26];

        for( int i = 0; i < word.length(); i++ ){
            freqArr[word.charAt(i)-'a'] = 1;
        }

        return freqArr;

    }
}
