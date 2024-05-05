package leetcode.easy;

import java.util.Arrays;

//[4,5,2,1]
//[3,10,21]
//[2,3,4,5]
//[1]
//[5,4,3,8,9,7,1,2,3,5]
//[3,2,1,6,89]
//[5,4,3,8,9,7,1,2,3,5,55,31,21,8,6,44]
//[3,2,1,6,89,7,55,43]
//[2]
//[1]
//[1]
//[2]
//[1,2]
//[3]
public class L2389LongestSubsequenceWithSum {

    public int[] answerQueries1(int[] nums, int[] queries) {

        Arrays.sort(nums);
        Arrays.sort(queries);

        int[] answer = new int[queries.length];

        for( int i = 1; i < nums.length; i++ ){
            nums[i] = nums[i]+nums[i-1];
        }

        int p1 = 0;
        int p2 = 0;

        while( p1 < nums.length && p2 < queries.length ){
            while( (p1 < nums.length) && (nums[p1] <= queries[p2]) ){
                p1++;
                answer[p2] = p1;
            }

            while( (p1 < nums.length && p2 < queries.length) && (nums[p1] > queries[p2]) ){
                answer[p2] = p1;
                p2++;
            }
        }

        while( p2 < queries.length ){
            answer[p2++] = p1;
        }

        return answer;
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int[] answer = new int[queries.length];

        for( int m = 0; m < queries.length; m++ ){
            int sum = 0;
            for( int i = 0; i < nums.length; i++ ){
                sum += nums[i];

                if( sum == queries[m] ) {
                    answer[m] = i+1;
                    break;
                }

                if( sum > queries[m] ) {
                    answer[m] = i;
                    break;
                }
            }

            if( sum < queries[m] ) {
                answer[m] = nums.length;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        new L2389LongestSubsequenceWithSum().run();
    }

    public void run(){
        System.out.println(Arrays.toString(answerQueries(new int[]{4,5,2,1}, new int[]{3,10,21})));
    }

}
