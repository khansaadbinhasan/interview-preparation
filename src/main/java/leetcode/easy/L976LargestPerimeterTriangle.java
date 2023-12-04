package leetcode.easy;

import java.util.*;

//[2,1,2]
//[1,2,1,10]
//[1,2,1,10,10,10,10,100,120,11,1323,3232,1112,2112]
//[1,120,11,1323,3232,1112,2112]
//[1,120,11]
//[1,1,1]
//[1,1,2]
//[1,2,3,10]
public class L976LargestPerimeterTriangle {

    public int largestPerimeter(int[] nums) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for( int i = 0; i < nums.length; i++ ){
            maxHeap.add(nums[i]);
        }

        int side1 = maxHeap.poll();
        int side2 = maxHeap.poll();
        int side3 = maxHeap.poll();

        if( isTriangle(side1, side2, side3) ) return side1 + side2 + side3;

        while( !maxHeap.isEmpty() ){
            side1 = side2;
            side2 = side3;
            side3 = maxHeap.poll();
            if( isTriangle(side1, side2, side3) ) return side1 + side2 + side3;
        }

        return 0;
    }

    public boolean isTriangle(int side1, int side2, int side3){
        return (side1 + side2 > side3) && (side2 + side3 > side1) && (side1 + side3 > side2);
    }

}
