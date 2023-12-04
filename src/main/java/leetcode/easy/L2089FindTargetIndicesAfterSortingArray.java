package leetcode.easy;

import java.util.*;

//[1,2,5,2,3]
//2
//[1,2,5,2,3]
//3
//[1,2,5,2,3]
//5
//[5,5,5,5,5]
//5
//[5,5,5,5,5]
//1
//[1,2,5,2,3]
//4
public class L2089FindTargetIndicesAfterSortingArray {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        LinkedList<Integer> targetIndices = new LinkedList<>();

        int index = Arrays.binarySearch(nums, target);

        if( index < 0 || index >= nums.length ){
            return new LinkedList<>();
        }

        targetIndices.add(index);

        int newIndex = index-1;
        while( newIndex >= 0 && nums[newIndex] == target ){
            targetIndices.addFirst(newIndex--);
        }


        newIndex = index+1;
        while( newIndex < nums.length && nums[newIndex] == target ){
            targetIndices.add(newIndex++);
        }

        return targetIndices;
    }
}
