package leetcode.medium;

//[1,0,1,0,1]
//2
//[0,0,0,0,0]
//0
//[1,0,1,1,0,0,0,0,1,1,1,0,0,0,0,0]
//3
//[1,0,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1]
//5
//[1]
//1
//[0]
//1
//[1,1]
//1
//[1,0,1]
//2
public class L930BinarySubarrayWithSums {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int num = 0;

        // while( start <= end && end < nums.length ){
        //     if( sum < goal ){
        //         end++;
        //         if( end >= nums.length ) break;
        //         sum += nums[end];
        //     }
        //     else if( sum > goal ){
        //         start++;
        //         if( start >= nums.length ) break;
        //         sum -= nums[start];
        //     }
        //     else{

        //     }
        // }


        for( int i = 0; i < nums.length; i++ ){
            sum = 0;
            for( int j = i; j < nums.length && sum <= goal; j++ ){
                sum += nums[j];
                if( sum == goal ) num++;
            }
        }

        return num;
    }
}
