package leetcode.medium;

import java.util.*;

//"aacaba"
//"abcd"
//"adsjkfhjkdashfjkldashfjkahdsgkfjhdiusfdhasirew"
//"dsfjkhadsjkfkdsfjfjhadsofkpopoqpwopqowpqowpqowppppfjkahdsgkfjhksjdkhjhqjkalll"
//"alalallalallllalllalalallala"
//"a"
public class L1525NumberOfWaysToSplitAString {

    public int numSplits(String s) {

        int[] left = new int[s.length()];
        int[] right = new int[s.length()];

        Set<Character> distinct = new HashSet<>();

        for( int i = 0; i < s.length(); i++ ){
            distinct.add(s.charAt(i));
            left[i] = distinct.size();
        }

        distinct = new HashSet<>();

        for( int i = s.length()-1; i >= 0; i-- ){
            distinct.add(s.charAt(i));
            right[i] = distinct.size();
        }

        int goodSplits = 0;

        for(int i = 0; i < left.length-1; i++ ){
            if( left[i] == right[i+1] ) goodSplits++;
        }

        return goodSplits;
    }

}
