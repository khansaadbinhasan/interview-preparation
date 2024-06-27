package leetcode.medium;

import java.util.*;

//[5,5,4]
//1
//[4,3,1,1,3,3,2]
//3
//[1]
//1
//[1000000000,99999,110,1000000000,99999,110,1000000000,99999,110,1000000000,99999,110,1000000000,99999,110,1000000000,99999,110,1000000000,99999,110,1000000000,99999,110]
//3
//[1,1,2]
//2
//[1,1,1,1,1,13,3,3,3,3,32,2,2,2,2,2]
//0
public class L1481LeastNumberOfUniqueAfterKRemovals {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, int[]> createFreqMap = new HashMap<>();

        for( int i = 0; i < arr.length; i++ ){
            createFreqMap.putIfAbsent(arr[i], new int[]{arr[i], 0});
            createFreqMap.get(arr[i])[1] = createFreqMap.get(arr[i])[1]+1;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                new Comparator<int[]>(){
                    @Override
                    public int compare(int[] a, int[] b){
                        return Integer.compare(a[1], b[1]);
                    }
                }
        );

        for( Integer key: createFreqMap.keySet() ){
            minHeap.add(createFreqMap.get(key));
        }

        int t = 0;

        while( !minHeap.isEmpty() ){
            t += minHeap.poll()[1];
            if( t == k ) return minHeap.size();
            if( t > k ){
                return minHeap.size()+1;
            }
        }

        return 0;
    }
}
