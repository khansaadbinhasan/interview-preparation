package leetcode.medium;


import java.util.*;

//[23,2,4,6,7]
//6
//[23,2,6,4,7]
//6
//[23,2,6,4,7]
//13
//[1]
//1
//[1,2,3]
//2
//[1,2]
//3
//[5,0,0,0]
//3
public class L523ContinuousSubarraySum {

    public boolean checkSubarraySumI(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }

        Set<Integer> intSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if( intSet.contains(nums[i] % k) || intSet.contains(0) ) return true;
            intSet.add(nums[i] % k);
        }

        return false;
    }

    public boolean checkSubarraySumII(int[] nums, int k) {

        // int p1 = 0;
        // int p2 = 0;

        // //[23,2,4,6,7]
        // //[23,25,29,35,42]
        // //[42,19,17,13,7]

        // while( p1 <= p2 ){

        // }

        for( int i = 0; i < nums.length; i++ ){
            int sum = nums[i];
            for( int j = i+1; j < nums.length; j++ ){
                sum += nums[j];

                if( sum % k == 0 ) return true;
            }
        }

        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for( int i = 0; i < nums.length; i++ ){
            nums[i] = nums[i] % k;
        }

        int sum = 0;
        for( int i = 0; i < nums.length; i++ ){
            sum = (sum + nums[i]) % k;

            if( sum == 0 && i >= 1 ) return true;

            if( map.containsKey(sum) ){
                if( i-map.get(sum) >= 2 ) return true;
            }

            else map.put(sum, i);
        }

        return false;
    }

    public static void main(String[] args) {
        new L523ContinuousSubarraySum().run();
    }

    public void run(){
        System.out.println(checkSubarraySum(new int[]{5,0,0,0}, 3));
    }

}
