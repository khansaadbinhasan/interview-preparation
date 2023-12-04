package leetcode.medium;

import java.util.*;

public class L2348NumZeroFilledArrays {


    public static void main(String[] args) {
        new L2348NumZeroFilledArrays().run();
    }

    public void run(){
        int[] arr = new int[100000];
        System.out.println(zeroFilledSubarray(arr));
    }

    public long zeroFilledSubarray(int[] nums) {
        List<Long> zeroList = new LinkedList<>();

        for( int i = 0; i < nums.length; i++ ){
            int start = i;
            while( i < nums.length && nums[i] == 0 ){
                i++;
            }

            if( i > start ){
                zeroList.add((long) (i - start));
                i--;
            }
        }

        long count = 0;

        for( int i = 0; i < zeroList.size(); i++ ){
            count += (zeroList.get(i)*(zeroList.get(i)+1))/2;
        }

        return count;
    }

}
