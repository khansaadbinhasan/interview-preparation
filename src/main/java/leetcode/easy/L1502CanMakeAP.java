package leetcode.easy;

import java.util.*;

//[3,5,1]
//[1,2,4]
public class L1502CanMakeAP {

    public boolean canMakeArithmeticProgression(int[] arr) {

        Arrays.sort(arr);

        int d = arr[1] - arr[0];
        int prev = arr[1];

        for( int i = 2; i < arr.length; i++ ){

            if( arr[i] - prev != d ) return false;

            prev = arr[i];
        }

        return true;
    }

}
