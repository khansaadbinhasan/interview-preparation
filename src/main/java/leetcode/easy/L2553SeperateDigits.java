package leetcode.easy;

import java.util.*;

//[13,25,83,77]
//[7,1,3,9]
//[1]
//[1,1,12,120]
public class L2553SeperateDigits {

    public int[] separateDigits(int[] nums) {

        int arrLen = 0;

        for( int i = 0; i < nums.length; i++ ){
            arrLen += numLen(nums[i]);
        }

        int[] separate = new int[arrLen];

        int ind = 0;

        for( int i = 0; i < nums.length; i++ ){
            for( Integer a: numsSeperated(nums[i]) ){
                separate[ind++] = a;
            }
        }

        return separate;
    }

    public int numLen(int num){
        int numLen = 0;

        while( num != 0 ){
            num = num / 10;
            numLen++;
        }

        return numLen;
    }

    public List<Integer> numsSeperated(int num){

        List<Integer> numsSeperated = new LinkedList<>();

        while( num != 0 ){
            int digit = num % 10;
            numsSeperated.add(digit);
            num = num / 10;
        }

        Collections.reverse(numsSeperated);

        return numsSeperated;
    }
}
