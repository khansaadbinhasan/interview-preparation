package leetcode.easy;

import java.util.*;

//22
//8
//5
//1
//1000000000
//8973898
//787867575
//76755555
public class L868BinaryGap {

    public int binaryGap(int n) {

        List<Integer> oneList = new LinkedList<>();

        int i = 0;
        while( n != 0 ){
            if( (n & 1) == 1 ) oneList.add(i);
            i++;
            n = n >>> 1;
        }

        int max = 0;
        int start = 0;

        for( i = 1; i < oneList.size(); i++ ){
            int diff = oneList.get(i) - oneList.get(i-1);
            max = Math.max(max, diff);
        }

        return max;
    }
}
