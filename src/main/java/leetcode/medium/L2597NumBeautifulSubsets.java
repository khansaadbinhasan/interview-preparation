package leetcode.medium;

import java.util.*;

//[2,4,6]
//2
//[1]
//1
//[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
//1
//[1,2,3,4]
//1
//[10,4,5,7,2,1]
//3
public class L2597NumBeautifulSubsets {
    public static void main(String[] args) {

    }

    int subsetCount = 0;
    public int beautifulSubsets(int[] nums, int k) {
        getSubsetCount(nums, k, 0, new LinkedList<>());
        return subsetCount;
    }

    public void getSubsetCount(int[] nums, int k, int i, List<Integer> subset){
        if( i >= nums.length ){
            if( !isDiffk(subset, k) ) {
                subsetCount++;
            }
            return;
        }

        getSubsetCount(nums, k, i+1, subset);
        subset.add((Integer) nums[i]);
        getSubsetCount(nums, k, i+1, subset);
        subset.remove((Integer) nums[i]);
    }

    public boolean isDiffk(List<Integer> subset, int k){
        if( subset.isEmpty() ) return true;

        // Collections.sort(subset);

        for( int i = 0; i < subset.size(); i++ ){
            for( int j = i+1; j < subset.size(); j++ ){
                if( Math.abs(subset.get(i) - subset.get(j)) == k ) return true;
            }
        }

        return false;
    }
}
