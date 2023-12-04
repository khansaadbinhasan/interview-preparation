package leetcode.easy;

import java.util.*;

//[1,2,3,4]
//[2,4,1,3]
//[7]
//[7]
//[1,12]
//[12,1]
//[3,7,9]
//[3,7,11]
//[1,1,1,1,1]
//[1,1,1,1,1]
//[1,2,3,4]
//[4,1,2,3]
public class L1460MakeTwoArraysByReversing {

    public boolean canBeEqual(int[] target, int[] arr) {

        int[] freqArrTarget = new int[1001];
        int[] freqArrArr = new int[1001];

        for( int num: target ) freqArrTarget[num]++;
        for( int num: arr ) freqArrArr[num]++;

        return Arrays.equals(freqArrTarget, freqArrArr);
    }

}
