package leetcode.medium;

import java.util.*;

public class L1177CanMakePalindromeFromSubstring {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new LinkedList<>();

        for( int i = 0; i < queries.length; i++ ){
            result.add(makePalindrome(s.substring(queries[i][0], queries[i][1]+1)) <= queries[i][2]);
        }

        return result;
    }

    public int makePalindrome(String s){

        int[] freqArr = new int[26];

        for( char c: s.toCharArray() ){
            freqArr[c-'a']++;
        }

        int numOdds = 0;

        for( int i = 0; i < freqArr.length; i++ ){
            if( freqArr[i] % 2 != 0 ) numOdds++;
        }

        return numOdds/2;

    }

    int[][] numOdds;
    public List<Boolean> canMakePaliQueries2(String s, int[][] queries) {
        numOdds = new int[s.length()+2][26];

        int[] freqArr = new int[26];

        for( int i = 0; i < s.length(); i++ ){
            freqArr[s.charAt(i)-'a']++;
            numOdds[i+1] = freqArr.clone();
        }

        List<Boolean> result = new LinkedList<>();

        for( int i = 0; i < queries.length; i++ ){
            result.add(getMinChanges(queries[i][0], queries[i][1]) <= queries[i][2]);
        }

        return result;
    }

    public int getMinChanges(int i, int j){
        int odds = 0;

        for( int k = 0; k < numOdds[i].length; k++ ){
            if( (numOdds[j+1][k]-numOdds[i][k]) % 2 != 0 ) odds++;
        }

        return odds/2;
    }

}
