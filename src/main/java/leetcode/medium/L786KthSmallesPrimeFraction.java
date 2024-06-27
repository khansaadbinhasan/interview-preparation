package leetcode.medium;

import java.util.*;

//[1,2,3,5]
//3
//[1,7]
//1
//[1,2]
//1
//[1,3,5,7,11,13]
//3
public class L786KthSmallesPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(
                new Comparator<int[]>(){
                    @Override
                    public int compare(int[] a, int[] b){
                        return Integer.compare(a[0]*b[1],b[0]*a[1]);
                    }
                }
        );

        minHeap.add(new int[]{1,1});

        for( int i = 0; i < arr.length; i++ ){
            for( int j = i+1; j < arr.length; j++ ){
                minHeap.add(new int[]{arr[i],arr[j]});
            }
        }

        int i = 1;
        while ( !minHeap.isEmpty() ){
            int[] num = minHeap.poll();
            if( i == k ) return num;
            i++;
        }

        return new int[]{};
    }
}
