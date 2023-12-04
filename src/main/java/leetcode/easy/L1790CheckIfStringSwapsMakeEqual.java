package leetcode.easy;

import java.util.*;

//"bank"
//"kanb"
//"attack"
//"defend"
//"kelb"
//"kelb"
//"a"
//"b"
//"a"
//"a"
//"ajkdhfkjahdskfhlakjdshfksdhkl"
//"ajkdhfkjahdskfhlakjdshfksdhkl"
//"ajkdhfkjahdskfhlakjdshfksdhkl"
//"ajkdhfkjahdskfhlakjdshfkshdkl"
//"akjdhfkjahdskfhlakjdshfkshdkl"
//"ajkdhfkjahdskfhlakjdshfkshdkl"
public class L1790CheckIfStringSwapsMakeEqual {

    public boolean areAlmostEqual(String s1, String s2) {

        int[] f1 = getFreqArr(s1);
        int[] f2 = getFreqArr(s2);

        if( !Arrays.equals(f1, f2) ) return false;

        int diffs = 0;

        for( int i = 0; i < s1.length(); i++ ){
            if( s1.charAt(i) != s2.charAt(i) ) diffs++;
        }

        return diffs <= 2;
    }

    public int[] getFreqArr(String s){
        int[] freqArr = new int[26];

        for( int i = 0; i < s.length(); i++ ){
            freqArr[s.charAt(i)-'a']++;
        }

        return freqArr;
    }
}
