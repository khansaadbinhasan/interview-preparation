package leetcode.easy;

import java.util.*;

//1
//22
//47
//85
public class L728SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new LinkedList<>();

        for( int i = left; i <= right; i++ ){
            if( isSelfDividing(i) ) res.add(i);
        }

        return res;
    }

    public boolean isSelfDividing(int n){
        int num = n;

        while( num > 0 ){
            int digit = num % 10;
            num = num / 10;

            if( digit == 0 || n % digit != 0 ) return false;
        }

        return true;
    }

}
