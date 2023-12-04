package leetcode.easy;

import java.util.*;

//[1,1]
//[2,2]
//[1,2]
//[2,3]
//[2]
//[1,3]
//[1,2,3,4,5]
//[5,6,4,2]
public class L888FairSwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sum1 = 0;
        int sum2 = 0;
        Set<Integer> aliceSet = new HashSet<>();
        Set<Integer> bobSet = new HashSet<>();

        for( int i = 0; i < aliceSizes.length; i++ ){
            sum1 += aliceSizes[i];
            aliceSet.add(aliceSizes[i]);
        }

        for( int i = 0; i < bobSizes.length; i++ ){
            sum2 += bobSizes[i];
            bobSet.add(bobSizes[i]);
        }

        int avg = (sum1+sum2)/2;
        int diff = Math.abs(sum1-avg);

        if( sum1 > sum2 ){
            for( int i = 0; i < bobSizes.length; i++ ){
                int num = bobSizes[i]+diff;
                if( aliceSet.contains(num) ){
                    return new int[]{num, bobSizes[i]};
                }
            }
        }

        else{
            for( int i = 0; i < aliceSizes.length; i++ ){
                int num = aliceSizes[i]+diff;
                if( bobSet.contains(num) ){
                    return new int[]{aliceSizes[i], num};
                }
            }
        }

        return new int[]{};
    }
}
