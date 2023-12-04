package leetcode.easy;

import java.util.HashSet;

//7
//10
//9
public class L2652SumMultiples {

    public int sumOfMultiples(int n) {
        HashSet<Integer> numSet = new HashSet<>();

        int[] divs = new int[]{3,5,7};
        int sum = 0;

        for( int k = 0; k < divs.length; k++ ){
            for( int i = 1; i <= n && divs[k]*i <= n; i++ ){
                if( !numSet.contains(divs[k]*i) ){
                    numSet.add(divs[k]*i);
                    sum += divs[k]*i;
                }
            }
        }

        return sum;
    }}
