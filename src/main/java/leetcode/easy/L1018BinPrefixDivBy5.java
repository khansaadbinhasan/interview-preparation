package leetcode.easy;

import java.util.*;


//[0,1,1]
//[1,1,1]
//[0]
//[1]
//[1,1,1,1,1,1,1,1]
//[0,0,0,0,0,0]
//[0,1,0,1,0,1,0]
//[1,1,1,1,1]
//[1,1,0,0,0,1,0,0,1]
public class L1018BinPrefixDivBy5 {

    public static void main(String[] args) {
        new L1018BinPrefixDivBy5().run();
    }

    public void run(){
        System.out.println(prefixesDivBy5(new int[]{1,1,0,0,0,1,0,0,1}));
    }

    public List<Boolean> prefixesDivBy5(int[] nums) {

        List<Boolean> divBy5Lst = new LinkedList<>();

        for( int i = 0; i < nums.length; i++ ){
            divBy5Lst.add(isDiv5(nums, i));
        }

        return divBy5Lst;
    }

    private boolean isDiv5(int[] nums, int i){
        if( nums[i] == 0 ) return true;

        if( i < 2 ) return false;

        return (nums[i] == 1) && (nums[i - 1] == 0) && (nums[i - 2] == 1);
    }
}
