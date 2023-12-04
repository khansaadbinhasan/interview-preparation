package leetcode.medium;

import java.util.*;

//[4,6,5,9,3,7]
//[0,0,2]
//[2,3,5]
//[-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10]
//[0,1,6,4,8,7]
//[4,4,9,7,9,10]
//[4,6,5,9,3,7]
//[2,2,3]
//[5,3,4]
public class L1630ArithmeticSubArrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> boolArr = new LinkedList<>();

        for( int k = 0; k < l.length; k++ ){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for( int i = l[k]; i <= r[k]; i++ ){
                pq.add(nums[i]);
            }

            boolean ans = true;
            int num1 = pq.poll();
            int diff = Integer.MAX_VALUE;

            while( !pq.isEmpty() ){
                int num2 = pq.poll();

                if( diff == Integer.MAX_VALUE ) diff = num2 - num1;

                if( diff != (num2-num1) ) {
                    ans = false;
                    break;
                }

                num1 = num2;
            }

            boolArr.add(ans);
        }

        return boolArr;
    }

}
