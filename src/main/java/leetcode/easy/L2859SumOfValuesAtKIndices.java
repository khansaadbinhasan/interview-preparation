package leetcode.easy;

import java.util.*;

//[5,10,1,5,2]
//1
//[4,3,2,1]
//2
//[1]
//0
//[100]
//1
//[1,2,3,4,100,98,53,1234]
//9
//[1,2,3,4,100,98,53,1234,1334]
//5
//[1,2,3,4,100,98,53,1234,100000]
//5
public class L2859SumOfValuesAtKIndices {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {

        int sum = 0;

        for( int i = 0; i < nums.size(); i++ ){
            if( get1s(i) == k ) sum += nums.get(i);
        }

        return sum;
    }

    public int get1s(int num){
        String binaryString = Integer.toBinaryString(num);
        return binaryString.length() - binaryString.replaceAll("1","").length();
    }
}
