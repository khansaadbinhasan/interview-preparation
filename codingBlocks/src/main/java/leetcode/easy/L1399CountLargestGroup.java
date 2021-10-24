package leetcode.easy;

import java.util.*;

//13
//2
//15
//24
//1
//10000
public class L1399CountLargestGroup {

    public int countLargestGroup(int n) {

        Map<Integer, Integer> map = new HashMap<>();

        int max = -1;

        for( int i = 1; i <= n; i++ ){

            int digSum = digitSum(i);

            int count = 0;

            if( map.containsKey(digSum) ) count = map.get(digSum) + 1;

            map.put(digSum, count);

            max = Math.max(max, count);
        }

        int countLarge = 0;

        for( int key: map.keySet() ){
            if( map.get(key) == max ) countLarge++;
        }

        return countLarge;

    }

    public int digitSum(int n){

        int sum = 0;

        while( n > 0 ){
            sum += n % 10;
            n = n / 10;
        }

        return sum;
    }


}
