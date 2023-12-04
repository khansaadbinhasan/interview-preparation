package leetcode.medium;

import java.util.*;

//[[8,7],[9,9],[7,4],[9,7]]
//[[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
public class L1637WidestVerticalArea {
    public int maxWidthOfVerticalArea(int[][] points) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for( int i = 0; i < points.length; i++ ){
            minHeap.add(points[i][0]);
        }

        int diff = 0;
        int p1 = minHeap.poll();

        while( !minHeap.isEmpty() ){
            int p2 = minHeap.poll();

            diff = Math.max(diff, p2-p1);
            p1 = p2;
        }

        return diff;

    }

}
