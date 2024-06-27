package leetcode.medium;

import java.util.*;

//[[10,16],[2,8],[1,6],[7,12]]
//[[1,2],[3,4],[5,6],[7,8]]
//[[1,2],[2,3],[3,4],[4,5]]
//[[1,2]]
//[[1,2],[3,4],[2,4]]

public class L452MinNumberOfArrowToBurst {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (int[] p1, int[] p2) -> Integer.compare(p1[0], p2[0]));

        int num1s = 0;

        for( int i = 1; i < points.length; i++ ){
            if( points[i-1][1] >= points[i][0] ){
                points[i][1] = Math.min(points[i-1][1],points[i][1]);
                num1s++;
            }
        }

        return points.length-num1s;
    }

}
