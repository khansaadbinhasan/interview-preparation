package leetcode.easy;

import java.util.*;

public class L2869LongestSubsetWithSum {

    public static void main(String[] args) {
        new L2869LongestSubsetWithSum().run();
    }

    public void run(){
        System.out.println(Arrays.toString(answerQueries(new int[]{4,5,2,1}, new int[]{3,10,21})));
    }

    public int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);
        Arrays.sort(queries);

        LinkedList<Integer> answer = new LinkedList<>();

        int i = 1;
        int j = 0;
        int sum = nums[0];

        while( i < nums.length && j < queries.length ){
            if( sum < queries[j] ) {
                sum += nums[i];
                answer.add(i);
                i++;
            }

            else{
                j++;
            }
        }

        while( answer.size() > queries.length ){
            answer.removeFirst();
        }

        for( i = 0; i < queries.length && !answer.isEmpty(); i++ ){
            queries[i] = answer.getFirst();
            answer.removeFirst();
        }

        return queries;
    }
}
