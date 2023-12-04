package leetcode.easy;

import java.util.*;

//[1,4,2]
//[5,4,4]
//[5,0,0]
//[100,0,99]
//[1,1,1]
//[5,6,7]
//[80,54,75]
//[65,43,56]
public class L2335MinAmtToFillCups {

    public int fillCups(int[] amount) {

        int total = 0;

        Arrays.sort(amount);

        while( amount[2] != 0 ){
            amount[2]--;
            amount[1]--;

            Arrays.sort(amount);
            total++;
        }

        return total;
    }
}
