package leetcode.easy;

import java.util.*;

//[[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
//[[1,2,3],[4,5,6]]
//[[1],[1]]
//[[1,2,3,4,5,6],[7]]
public class L2248IntersectionOfMultipleArrays {

    public static void main(String[] args) {
        new L2248IntersectionOfMultipleArrays().run();
    }

    public void run(){
        System.out.println(intersection(new int[][]{{3,1,2,4,5},{1,2,3,4},{3,4,5,6}}));
    }

    public List<Integer> intersection(int[][] nums) {

        int[] minLengthArr = nums[0];

        for( int i = 0; i < nums.length; i++ ){
            Arrays.sort(nums[i]);

            if( nums[i].length < minLengthArr.length ) {
                minLengthArr = nums[i];
            }
        }

        List<Integer> intersection = new LinkedList<>();

        for( int i = 0; i < minLengthArr.length; i++ ){
            boolean isInAll = false;

            for( int j = 0; j < nums.length; j++ ){
                int numIndex = Arrays.binarySearch(nums[j], minLengthArr[i]);

                if( numIndex >= 0 && numIndex < nums[j].length ){
                    isInAll = true;
                }

                else{
                    isInAll = false;
                    break;
                }
            }

            if( isInAll ) {
                intersection.add(minLengthArr[i]);
            }
        }

        return intersection;
    }
}
