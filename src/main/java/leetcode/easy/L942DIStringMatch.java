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
    }}
