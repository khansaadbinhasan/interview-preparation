package leetcode.easy;

import java.util.*;

public class L942DIStringMatch {

    Map<Integer, Integer> map = new HashMap<>();

//    public int[] diStringMatch(String s) {
//
//        for( int i = 1; i < s.length(); i++ ){
//            if( s.charAt(i-1) == 'I' );
//        }
//
//    }

    public void insert(int n, int i){

        if( !map.containsKey(n) ) {
            map.put(n, i);
            return;
        }

        insert(n+1, map.get(n));
        map.put(n, i);
    }

    //"IDID"
    //"III"
    //"DDI"
    //"I"
    //"D"
    //"IIIIIDDDDIDIIDIDIDID"
    //"DDDDDDDDDDDDDDDDDDDDDDDIIIIIIIIIIIIIDIDIIDIDIDI"
    //"DIDIIDIDIDIIDIDDDDDDDDDDIIIIIIIDDDDD"
    public int[] diStringMatch(String s) {

        int[] output = new int[s.length()+1];

        output[0] = s.length();

        for( int i = 0; i < s.length(); i++ ){

            if( s.charAt(i) == 'I' ){
                output[i+1] = output[i]+1;
            }

            else if( s.charAt(i) == 'D' ){
                output[i+1] = output[i]-1;
            }
        }

        // return output;
        return new int[]{3,4,2,3,2};
    }

    public int[] diStringMatch2(String s) {
        // int[] sorted = new int[s.length()+1];
        int[] di = new int[s.length()+1];

        int start = 0;
        int end = s.length();

        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) == 'I' ) di[i] = start++;
            if( s.charAt(i) == 'D' ) di[i] = end--;
        }

        if( start == end ) di[di.length-1] = start;

        return di;
    }
}
