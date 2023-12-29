package leetcode.medium;

import java.util.*;


//[[1,3],[2,6],[8,10],[15,18]]
//[[1,4],[4,5]]
//[[4,5],[1,4]]
//[[1,3],[8,10],[15,18],[4,7],[2,6]]
//[[1,3],[8,10],[15,18],[4,7],[2,6],[5,9],[11,99]]
//[[0,0]]
//[[1,5]]
public class L56MergeIntervals {

    public int[][] merge(int[][] intervals) {
        //[[1,3],[8,10],[15,18],[4,7],[2,6]]
        //[1,3]

        //assume sorted array based on the first element --> O(nlgn)
        //O(n)

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        return a[0]-b[0];
                    }
                }
        );

        priorityQueue.addAll(Arrays.asList(intervals));

        int r = 0;

        while( !priorityQueue.isEmpty() ){
            intervals[r++] = priorityQueue.poll();
        }

        int count = 0;

        for( int i = 1; i < intervals.length; i++ ){
            if( intervals[i][0] <= intervals[i-1][1] ) {
                intervals[i][0] = intervals[i-1][0];
                if( intervals[i-1][1] > intervals[i][1]  ){
                    intervals[i][1] = intervals[i-1][1];
                }
                intervals[i-1][0] = -100;
            }
        }

        for( int i = 0; i < intervals.length; i++ ){
            if( intervals[i][0] != -100 ) {
                count++;
            }
        }


        int[][] arr = new int[count][2];
        int k = 0;

        for( int i = 0; i < intervals.length; i++ ){
            if( intervals[i][0] != -100 ) {
                arr[k][0] = intervals[i][0];
                arr[k][1] = intervals[i][1];
                k++;
            }
        }

        return arr;
    }

}
