package leetcode.easy;

import java.util.*;

//[4,2,3]
//1
//[3,-1,0,2]
//3
//[2,-3,-1,5,-4]
//2
//[-1]
//2
//[-1]
//1
//[-1,1,1,1,1,-100]
//2
//[-100,-90,-80]
//3
//[-100,-90,-80]
//31
public class L1005MaxSumAfterKNegations {

    public static void main(String[] args) {
        new L1005MaxSumAfterKNegations().run();
    }

    public void run(){
        System.out.println(largestSumAfterKNegations(new int[]{3,-1,0,2}, 3));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int sum = 0;

        for( int i = 0; i < nums.length; i++ ){
            minHeap.add(nums[i]);
            sum += nums[i];
        }

        while( !minHeap.isEmpty() && k > 0 ){

            int elem = minHeap.poll();

            if( elem > 0 ) {
                if( k % 2 != 0 ) sum -= 2*elem;
                break;
            }

            sum += 2*(-elem);
            k--;
            minHeap.add(-elem);
        }

        return sum;

    }
}
