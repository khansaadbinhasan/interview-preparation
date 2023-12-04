package leetcode.easy;

import java.util.*;

//[4,1,4,0,3,5]
//[1,100]
//[1,1]
//[1,2,3,4,5,6,7,8,9,10,1,1,1,1,1,1,1,9,3,3,3,3,3,3,3,3,2,2,2,4,4,5,5,5,5,5]
//[1,2,3,4,5,6,7,8,9,10,1,1,1,1,1,1,1,9,3,3,3,3,3,3,3,3,2,2,2,4,4,5,5,5,5,5,5,1,2,3,4,5,6,7,8,9,10,1,1,1,1,1,1,1,9,3,3,3,3,3,3,3,3,2,2,2,4,4,5,5,5,5]
//[0,0,89,17,65,43]
//[1,2,3,9,10,1,1,9,3,3,2,2,2,4,4,5]
public class L2465NumberOfDistinctAverages {

    public static void main(String[] args) {
        new L2465NumberOfDistinctAverages().run();
    }

    public void run(){
        System.out.println(distinctAverages(new int[]{1,2,3,9,10,1,1,9,3,3,2,2,2,4,4,5}));
    }

    public int distinctAverages(int[] nums) {

        Set<Integer> distinctAverages = new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for( int i = 0; i < nums.length; i++ ){
            minHeap.add(nums[i]);
            maxHeap.add(nums[i]);
        }

        while( !minHeap.isEmpty() && !maxHeap.isEmpty() ){
            distinctAverages.add(minHeap.poll()+maxHeap.poll());
        }

        return distinctAverages.size();
    }
}



//[1,2,3,9,10,1,1,9,3,3,2,2,2,4,4,5]
//[1,1,1,2,2,2,2,3,3,3,4,4,5,9,9,10]
//1,10 --> 5.5
//1,9  --> 5
//1,9  --> 5
//2,5  --> 3.5
//2,4  --> 3
//2,4  --> 3
//2,3  --> 2.5
//3,3  --> 3