package leetcode.easy;

import java.util.*;

//"ab"
//"ba"
//"ab"
//"ab"
//"aa"
//"aa"
//"abcd"
//"dcba"
//"a"
//"b"
//"abcd"
//"abdc"
//"ddaa"
//"adad"
//"a"
//"a"
public class L859BuddyStrings {
    public boolean buddyStrings(String s, String goal) {

        int[] sFreq = freqArr(s);
        int[] goalFreq = freqArr(goal);

        if( !Arrays.equals(sFreq, goalFreq) ) return false;

        int diffs = 0;

        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) != goal.charAt(i) ) diffs++;
        }

        if( diffs == 0 ){
            for( int i = 0; i < sFreq.length; i++ ){
                if( sFreq[i] >= 2 ) return true;
            }
        }

        return diffs==2;
    }

    public int[] freqArr(String s){

        int[] freqArr = new int[26];

        for( int i = 0; i < s.length(); i++ ){
            freqArr[s.charAt(i)-'a']++;
        }

        return freqArr;
    }
}
